package com.pengjinfei.ch8.jpa.dao;

import com.pengjinfei.ch8.jpa.domain.Person;
import com.pengjinfei.ch8.jpa.support.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@RepositoryRestResource(path = "people")
public interface PersonRepository  extends CustomRepository<Person,Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    Person withNameAndAddressNamedQuery(String name, String address);

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);
}
