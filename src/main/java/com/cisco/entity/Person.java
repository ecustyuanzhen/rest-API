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

    public Person( int num, String name, int age) {
        this.personId = num;
        this.name = name;
        this.age = age;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getNum() {
        return personId;
    }

    public void setNum(int num) {
        this.personId = num;
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
                ", num=" + personId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}