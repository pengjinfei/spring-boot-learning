package com.pengjinfei.ch8.jpa;

import com.pengjinfei.ch8.jpa.dao.PersonRepository;
import com.pengjinfei.ch8.jpa.domain.Person;
import com.pengjinfei.ch8.jpa.service.DemoService;
import com.pengjinfei.ch8.jpa.support.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@Import(RepositoryRestMvcConfiguration.class)
@EnableCaching
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(Person person) {
//        Person person = new Person(name, age,address);
        personRepository.save(person);
        return person;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        return personRepository.findByAddress(address);
    }

    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        return personRepository.withNameAndAddressQuery(name, address);
    }

    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        return personRepository.withNameAndAddressNamedQuery(name, address);
    }

    @RequestMapping("/sort")
    public List<Person> sort() {
        return personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
    }

    @RequestMapping("/page")
    public Page<Person> page() {
        return personRepository.findAll(new PageRequest(1,2));
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
        return personRepository.findByAuto(person, new PageRequest(0, 10));
    }

    @Autowired
    DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person) {
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person) {
        return demoService.savePersonWithoutRollBack(person);
    }

    @RequestMapping("/put")
    public Person put(Person person) {
        return demoService.saveUseCache(person);
    }

    @RequestMapping("/able")
    public Person findOne(Person person) {
        return demoService.findOne(person);
    }

    @RequestMapping("/evict")
    public String evict(Long id) {
        demoService.removeUseCache(id);
        return "ok";
    }
}
