/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.salesinventory.util;

import com.abc.salesinventory.model.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Manuri
 */
public class CategoryXMLReader {

    public static List<Category> readCategories() {
        try {
            List<Category> categories = new ArrayList<Category>();

            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse("category.xml");

            XPath xpath = XPathFactory.newInstance().newXPath();
            // XPath Query for showing all nodes value
            XPathExpression expr = null;
            String xPathExpr = "/categories/category";
            expr = xpath.compile(xPathExpr);

            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            for (int i = 0; i < nodes.getLength(); i++) {
                Category category = new Category();
                category.setName(nodes.item(i).getAttributes().getNamedItem("name").getNodeValue());
                NodeList childNodes = nodes.item(i).getChildNodes().item(1).getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node nod = childNodes.item(j);
                    if(nod.getNodeType() == Node.ELEMENT_NODE)
                        category.addUnits(nod.getFirstChild().getNodeValue());
                }
                categories.add(category);
            }
            return categories;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CategoryXMLReader.class.getName()).error(ex);
        } catch (SAXException ex) {
            Logger.getLogger(CategoryXMLReader.class.getName()).error(ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(CategoryXMLReader.class.getName()).error(ex);
        } catch (IOException ex) {
            Logger.getLogger(CategoryXMLReader.class.getName()).error(ex);
        }
        return null;
    }
}
