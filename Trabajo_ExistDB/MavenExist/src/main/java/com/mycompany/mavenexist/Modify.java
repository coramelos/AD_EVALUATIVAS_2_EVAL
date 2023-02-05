/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenexist;

/**
 *
 * @author jaska
 */
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xmldb.api.DatabaseManager;

public class Modify {
    public static void main(String[] args) throws Exception {
        // Define the connection details
        String uri = "xmldb:exist://localhost:8080/exist/xmlrpc";
        String driver = "org.exist.xmldb.DatabaseImpl";
        String collection = "/db/contactos";
        String resource = "contacts.xml";
        String username = "admin";
        String password = "1234";

        // Initialize the database driver
        Class cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        DatabaseManager.registerDatabase(database);

        try ( // Get the collection and resource
                Collection col = DatabaseManager.getCollection(uri + collection, username, password)) {
            XMLResource res = (XMLResource) col.getResource(resource);
            // Get the DOM representation of the XML
            Document doc = (Document) res.getContentAsDOM();
            // Define the XPath expression to find the contact node with name "Jassi"
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr = xpath.compile("/contacts/contacto[nombre='Jassi']/id");
            // Evaluate the XPath expression to find the target node
            Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
            // Modify the node's text content to the new value
            node.setTextContent("4");
            // Store the modified XML back to the database
            res.setContentAsDOM(doc);
            col.storeResource(res);
            // Release the resources
        }
    }
}
