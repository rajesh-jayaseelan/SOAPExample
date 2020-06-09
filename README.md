# SOAPExample
 Simple SOAP Web Service Example for refs.
 
 *********************************************************
 SOAP API Testing - How to run SOAP request in Postman
 					*newman is cmdline tool for postman
 *********************************************************
 
 Step 1. Get Soap request url or WSDL url add to request url
 		 e.g http://localhost:8080/SOAPExample/services/PersonServiceImpl?wsdl
 
 Step 2. Set method as Post in Postman client webstore app dropdown
         Headers - 1. Content-Type application/xml
         		   2. SOAPAction   addPerson e.g wsdl exposed method name.
 
 Step 3. Set body as raw and set text/xml   
 
 Step 4. Provide request data in body
 
 Step 5: Run and validate using newman i.e from cmdline type 'newman run uri'
 
 * we can use wsimport tool of jdk i.e
 wsimport -keep -verbose -s ./src/ -d ./bin/ <WSDL URL> 
 
 ref url - https://www.journaldev.com/9133/jax-ws-web-service-deployment-on-tomcat-server ,
 https://www.youtube.com/watch?v=fE1pVSiXNkU
 
 
