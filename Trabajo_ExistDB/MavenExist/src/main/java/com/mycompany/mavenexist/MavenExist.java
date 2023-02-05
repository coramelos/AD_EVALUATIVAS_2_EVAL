/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenexist;


import java.io.StringReader;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.exist.xmldb.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.xmldb.api.DatabaseManager;

public class MavenExist {
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
      res = (XMLResource)col.getResource(documentName);
      
      // get document
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new InputSource(new StringReader((String)res.getContent())));
      
      // retrieve contacts
      NodeList contacts = doc.getElementsByTagName("contacto");
      for (int i = 0; i < contacts.getLength(); i++) {
        Node contact = contacts.item(i);
        if (contact.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element)contact;
          System.out.println("ID: " + eElement.getElementsByTagName("id").item(0).getTextContent());
          System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
          System.out.println("Telefono: " + eElement.getElementsByTagName("telefono").item(0).getTextContent());
        }
      }
    } finally {
      // cleanup
      if (res != null) {
        try {
          ((EXistResource)res).freeResources();
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
