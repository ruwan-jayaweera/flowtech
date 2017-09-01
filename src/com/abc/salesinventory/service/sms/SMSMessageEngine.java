package com.abc.salesinventory.service.sms;

import com.abc.salesinventory.model.newpackage.Supplier;
import com.abc.salesinventory.report.SupplierDetailsReport;
import com.abc.salesinventory.service.newpackage.InventoryService;
import com.abc.salesinventory.service.newpackage.InventoryServiceImpl;
import com.abc.salesinventory.service.newpackage.MasterService;
import com.abc.salesinventory.service.newpackage.MasterServiceImpl;
import com.abc.salesinventory.ui.newpackage.NewMessageReceivedNotification;
import org.smslib.GatewayException;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Message;

public class SMSMessageEngine {

    private static Service messageService;
    MasterService masterService = new MasterServiceImpl();

    private String comPort = CommPortTester.getConnectedPort();
    private Integer baudRate = 9600;

    private JDesktopPane jDesktopPane;

    public void init() {

        try {
            SerialModemGateway gateway = new SerialModemGateway("", comPort, baudRate.intValue(), "", "");
            gateway.setInbound(true);
            gateway.setOutbound(true);
            gateway.setSmscNumber("+947100003");
            InboundNotification inboundNotification = new InboundNotification();
            messageService = Service.getInstance();
            messageService.setInboundMessageNotification(inboundNotification);
            messageService.addGateway(gateway);
            messageService.startService();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        try {
            messageService.stopService();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public OutboundMessage.MessageStatuses sendSMSMessage(String recipient, String msgText) throws InterruptedException, TimeoutException, GatewayException, IOException {

        OutboundMessage.MessageStatuses status = OutboundMessage.MessageStatuses.SENT;
        OutboundMessage msg = new OutboundMessage(recipient, msgText);
        messageService.sendMessage(msg);
        if (msg.getMessageStatus() != OutboundMessage.MessageStatuses.SENT) {
            status = OutboundMessage.MessageStatuses.FAILED;
            JOptionPane.showMessageDialog(this.getjDesktopPane(), "Sending message failed.");
            return status;
        }
        JOptionPane.showMessageDialog(this.getjDesktopPane(), "Sending message successfull.");

        com.abc.salesinventory.model.newpackage.Message message = new com.abc.salesinventory.model.newpackage.Message();
        message.setId(UUID.randomUUID().toString());
        message.setMessage(msgText);
        message.setMessageType("Outgoing");
        message.setMsgDate(new Date());
        message.setContactNumber(recipient);

        Supplier supplier = masterService.getSupplierByMobile(recipient);
        message.setSupplier(supplier);
        masterService.saveMessage(message);

        return status;
    }

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void setjDesktopPane(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }

    private class InboundNotification implements IInboundMessageNotification {

        @Override
        public void process(AGateway gateway, Message.MessageTypes messageTypes, InboundMessage inboundMessage) {

            try {
                System.out.println("SMS message received: " + inboundMessage.getText());

                String content = inboundMessage.getText();
                com.abc.salesinventory.model.newpackage.Message message = new com.abc.salesinventory.model.newpackage.Message();
                message.setId(UUID.randomUUID().toString());
                message.setMessage(content);
                message.setMessageType("Incoming");
                message.setMsgDate(new Date());
                message.setContactNumber(inboundMessage.getOriginator());

                Supplier supplier = masterService.getSupplierByMobile(inboundMessage.getOriginator());
                message.setSupplier(supplier);
                masterService.saveMessage(message);

                getjDesktopPane().add(new NewMessageReceivedNotification(message,getjDesktopPane())).setVisible(true);

                gateway.deleteMessage(inboundMessage);
            } catch (Exception e) {
                System.out.println("Failure in processing incoming message : " + e);
            }
        }
    }

    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    public String getComPort() {
        return comPort;
    }

    public void setComPort(String comPort) {
        this.comPort = comPort;
    }

}
