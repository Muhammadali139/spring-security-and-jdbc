package com.data.springsecurityandjdbc;

//create database db_example;  Creates the new database
// create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
// grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

import javax.persistence.*;

@Entity
@Table(name = "aboutEmployee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "salary")
    Long salary;

    @Column(name = "email")
    String email;

    @Column(name = "age")
    Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
