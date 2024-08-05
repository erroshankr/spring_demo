package com.spring.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //registers the class in the spring container
public class Student {
    /**
     * <bean id= "std" class= "com.spring.demo.Student>
     *    <property name="name" value = "Roshan"/> // calls setter method
     *    <property name="rollNo" value = "10"/> // calls setter method
     * </bean>
     */
    @Value("${student.name: Roshan}")
    private String name;
    @Value("${student.rollNo: 10}")
    private int rollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
