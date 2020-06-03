package com.journaldev.jaxws.client;

import javax.xml.ws.WebServiceRef;

import com.journaldev.jaxws.beans.Person;
import com.journaldev.jaxws.service.PersonService;

//https://docs.oracle.com/cd/E19316-01/819-3669/6n5sg7bi9/index.html
public class PersonServiceClient {

	@WebServiceRef(wsdlLocation="http://localhost:8080/SOAPExample/services/PersonServiceImpl?WSDL")
    static PersonService service;

    public static void main(String[] args) {
        try {
        	PersonServiceClient client = new PersonServiceClient();
            client.doTest(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void doTest(String[] args) {
        try {
        	 
        	 Integer id=0;
             if (args.length > 0) {
                 id = Integer.parseInt(args[0]!=null?args[0].trim():args[0]);
             } else {
                 id = 1;
             }
        	
            System.out.println("Retrieving the port from the following service: " + service);
            Person person = service.getPerson(id);
            System.out.println("Invoking the Person Service operation on the port.");

           
            if(person!=null)
            	System.out.println(service.checkPersonId(id));
            else
            	System.out.println("Person not Added!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
