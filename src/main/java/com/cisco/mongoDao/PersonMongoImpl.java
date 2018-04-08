package com.cisco.mongoDao;

import com.cisco.entity.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by liu on 2017/6/7.
 */

@Repository("personMongoImpl")
public class PersonMongoImpl {

    @Resource
    private MongoTemplate mongoTemplate;

    public void add(Person person) {
        mongoTemplate.insert(person, "person");
    }
    public List<Person> findAll() {
        return mongoTemplate.findAll(Person.class, "person");
    }

    public void insertPerson(Person person) {
        mongoTemplate.insert(person, "person");
    }

    public void removePerson(int personId) {
        mongoTemplate.remove(Query.query(Criteria.where("personId").is(personId)), "person");
    }

    public void updatePerson() {
        mongoTemplate.updateMulti(Query.query(Criteria.where("age").gt(3).lte(5)), Update.update("age", 3), "person");
    }

    public List<Person> findForRequery(int personId) {
        return mongoTemplate.find(Query.query(Criteria.where("personId").is(personId)), Person.class);
    }
    public Person getPersonByPersonId(int personId){
        return mongoTemplate.findOne(Query.query(Criteria.where("personId").is(personId)),Person.class);
    }
}
