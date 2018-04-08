package com.cisco.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Document(collection = "person")
public class Person implements Serializable {

    @Id
    private ObjectId id;
    private int personId;
    private String name;
    private int age;

    public Person() {
    }

    public Person( int personId, String name, int age) {
        this.personId = personId;
        this.name = name;
        this.age = age;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}