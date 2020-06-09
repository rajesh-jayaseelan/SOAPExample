package com.journaldev.jaxws.service;

import javax.jws.WebService;

import com.journaldev.jaxws.beans.Person;

@WebService
public interface PersonService {
 
    public boolean addPerson(Person p);
     
    public boolean deletePerson(int id);
     
    public Person getPerson(int id);
     
    public Person[] getAllPersons();
    
}