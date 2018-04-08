package com.cisco.controller;
import com.cisco.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cisco.mongoDao.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
@ResponseBody
public class mongoController {
    @Resource
    private PersonMongoImpl personMongo;//调用模板方法mongotemplate
//    @Resource
//    private PersonDao personDao;//调用MongoRepository扩展接口来查询
    List<Person> arrayList = new ArrayList();
    Map<String,Object> personMap = new HashMap<String, Object>();

    /**
     * 查询person信息(如果不加占位符访问？？？)
     * @param personId
     * @return
     */
    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET)
    public Map<String,Object> getPerson(@PathVariable(value = "personId")Integer personId){

        arrayList=personMongo.findForRequery(personId);
        personMap.put("FindPersons",arrayList);
        return  personMap;
    }

    /**
     * 添加person信息
     * @return
     */
    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public Map<String,Object> addPerson(@RequestParam int personId,String name,int age){
        Person person = new Person(personId,name,age);
        personMongo.add(person);
        personMap.put("AddPerson",person);
        return personMap;
    }
    /**
     * 修改person信息
     */
    @RequestMapping(value = "/person",method = RequestMethod.PUT)
    public Map<String,Object> updatePerson(@RequestParam int personId,String name,int age){
        Person person = personMongo.getPersonByPersonId(personId);
        person.setName(name);
        person.setAge(age);
        personMongo.insertPerson(person);
        personMap.put("UpdatePerson",person);
        return personMap;
    }
    @RequestMapping(value = "/person",method = RequestMethod.DELETE)
    public Map<String,Object> deletePerson(@RequestParam int personId){
        personMongo.removePerson(personId);
        arrayList = personMongo.findAll();
        personMap.put("ReservePerson",arrayList);
        return personMap;
    }

}
