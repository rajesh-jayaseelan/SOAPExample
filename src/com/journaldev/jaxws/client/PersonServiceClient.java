package com.journaldev.jaxws.client;

import javax.xml.ws.WebServiceRef;

import com.journaldev.jaxws.beans.Person;
import com.journaldev.jaxws.service.PersonService;

//https://docs.oracle.com/cd/E19316-01/819-3669/6n5sg7bi9/index.html
public class PersonServiceClient {
	
	//private static final String SERVICE_NAME = "PersonServiceImpl";
	//private static final String WSDL_LOCATION = "http://localhost:8080/SOAPExample/services/PersonServiceImplService?wsdl";
	//private Service service;
	@WebServiceRef(wsdlLocation="http://localhost:8080/SOAPWSExample/services/PersonServiceImpl?wsdl")//"http://localhost:8080/SOAPExample/services/PersonServiceImpl?wsdl")
    static PersonService service;
	
	/*public PersonServiceClient() throws Exception {
		 service = Service.create(new URL(WSDL_LOCATION), new QName(SERVICE_NAME));
	}*/
	
	/*private void callWS(){
		URL wsdlURL = new URL("http://localhost:8080/SOAPExample/services/PersonServiceImpl?wsdl");
		//check above URL in browser, you should see WSDL file
		
		//creating QName using targetNamespace and name
		QName qname = new QName("https://service.jaxws.journaldev.com/", "PersonServiceImpl"); 
		
		Service service = Service.create(wsdlURL, qname);  
		
		//We need to pass interface and model beans to client
		PersonServiceImpl ps = service.getPort(PersonServiceImpl.class);
		
		Person p1 = new Person(); p1.setName("Pankaj"); p1.setId(1); p1.setAge(30);
		Person p2 = new Person(); p2.setName("Meghna"); p2.setId(2); p2.setAge(25);
		
		//add person
		System.out.println("Add Person Status="+ps.addPerson(p1));
		System.out.println("Add Person Status="+ps.addPerson(p2));
		
		//get person
		System.out.println(ps.getPerson(1));
		
		//get all persons
		System.out.println(Arrays.asList(ps.getAllPersons()));
		
		//delete person
		System.out.println("Delete Person Status="+ps.deletePerson(2));
		
		//get all persons
		System.out.println(Arrays.asList(ps.getAllPersons()));
	}*/
	
    public static void main(String[] args) {
    	
    	PersonServiceClient client=null;
    	
        try {
        	client = new PersonServiceClient();
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
            //Person person = service.getPerson(id);
            Person person = null;
            
            if(service!=null) {
            	
            	person=service.getPerson(id);
            	System.out.println("Invoking the Person Service operation on the port.");
           
	            if(person!=null)
	            	System.out.println("Person Id and Name :::"+person.getId()+" , "+person.getName());
	            else
	            	System.out.println("Person not Added!");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
