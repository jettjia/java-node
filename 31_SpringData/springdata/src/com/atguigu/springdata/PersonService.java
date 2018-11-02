package com.atguigu.springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepsotory personRepsotory;
    
    @Transactional
    public void savePerson(List<Person> persons) {
        personRepsotory.save(persons);
    }
    
    @Transactional
    public void updatePersonEmail(Integer id, String email) {
        personRepsotory.updatePersonEmail(id, email);
    }
}
