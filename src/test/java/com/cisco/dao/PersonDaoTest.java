package com.cisco.dao;

import com.cisco.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-mongo.xml"})
public class PersonDaoTest {
    @Resource
    private PersonDao personDao;

    /**
     * 插入数据
     */
    @Test
    public void testMongo() {
//        List<Person> persons = new ArrayList<Person>();
//        persons.add(new Person(1,"zhenyuan",24));
//        personDao.save(persons);
    }

}