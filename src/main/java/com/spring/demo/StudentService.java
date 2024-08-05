package com.spring.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StudentService {

    /**
     * <bean id="studentService" class = "com.spring.demo.StudentService>
     *  </bean>
     *
     */
    public void display(Student st){
        System.out.println(st + " : student");
        System.out.println(st.getName() + " - " + st.getRollNo());
        System.out.println(st + " : student");

    }
}
