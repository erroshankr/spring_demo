package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Spring framework : reduce code complexity, better way of interating with external app like DB, memory management, simple - modular code
//
// inversion of control is achieved thro dependency injection.
// dependency injection : is used to achieve inversion of control, manages dependency of a bean, provide loose coupling
@RestController // --> It returns object as it is like json --> no beautification
public class StudentJsonController {
    /**
     * <bean id ="studentController" name="com.spring.demo.StudentController">
     *     <property name="studentService" ref="studentService"/>
     *     <property name="student" ref="std"/>
     *  </bean>
     */
    @Autowired
    private StudentService studentService;

    @Autowired
    private Student student;

    @GetMapping("/detail")
    public String getDetail(){  // API -> Application Programming Interface
        try {
            System.out.println(studentService + " : studentService");
            System.out.println(student.getName() + " - " + student.getRollNo()); // value present during spring container initialization
            student.setName("Rohit"); // value changed during runtime
            student.setRollNo(5); // // value changed during runtime
            studentService.display(student);
            return "SUCCESS";
        }catch (Exception e){
            return "FAILURE";
        }
    }

    @GetMapping("/showName")
    public String getName(){  // API -> Application Programming Interface
        try {
            System.out.println(studentService + " : studentService");
       //     Student s1 = new Student();
            return student.getName()+ " : "+String.valueOf(student.getRollNo());
        }catch (Exception e){
            return "FAILURE";
        }
    }

    @GetMapping("/showDetails")
    public String getAllInfo(){  // API -> Application Programming Interface
        try {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Rohit Sharma", 45));
            students.add(new Student("Virat Kohli", 18));
            students.add(new Student("Rahul Dravid",24));
            students.add(new Student("Sourav Ganguly", 04));
            students.add(new Student("MS Dhoni", 07));
            return "student_details";
        }catch (Exception e){
            return "FAILURE";
        }
    }
}
