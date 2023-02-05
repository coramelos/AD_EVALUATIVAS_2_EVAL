/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenexist;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.exist.xmldb.EXistResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

/**
 *
 * @author jaska
 */
public class Escribir {

    public static void main(String[] args) throws Exception {
        String uri = "xmldb:exist://localhost:8080/exist/xmlrpc";
        String collectionPath = "/db/contactos";
        String documentName = "contacts.xml";

        Collection col = null;
        XMLResource res = null;

        try {
            // initialize database driver
            Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
            Database database = (Database) cl.newInstance();
            DatabaseManager.registerDatabase(database);

            // get collection with authentication
            col = DatabaseManager.getCollection(uri + collectionPath, "admin", "1234");

            // retrieve XML resource
            res = (XMLResource) col.getResource(documentName);

            // get document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader((String) res.getContent())));

            // insert node
            Element root = doc.getDocumentElement();
            Element newContact = doc.createElement("contacto");
            Element newId = doc.createElement("id");
            Element newNombre = doc.createElement("nombre");
            Element newTelefono = doc.createElement("telefono");

            newId.appendChild(doc.createTextNode("1"));
            newNombre.appendChild(doc.createTextNode("Jassi"));
            newTelefono.appendChild(doc.createTextNode("123-456-7892"));

            newContact.appendChild(newId);
            newContact.appendChild(newNombre);
            newContact.appendChild(newTelefono);
            root.appendChild(newContact);

            // store XML resource
            StringWriter writer = new StringWriter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            res.setContent(writer.toString());
            col.storeResource(res);
        } finally {
            // cleanup
            if (res != null) {
                try {
                    ((EXistResource) res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
    }
}
