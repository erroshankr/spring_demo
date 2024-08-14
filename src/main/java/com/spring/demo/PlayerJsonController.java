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
public class PlayerJsonController {
    /**
     * <bean id ="studentController" name="com.spring.demo.StudentController">
     *     <property name="studentService" ref="studentService"/>
     *     <property name="student" ref="std"/>
     *  </bean>
     */
    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerModel playerModel;

    @GetMapping("/detail")
    public String getDetail(){  // API -> Application Programming Interface
        try {
            System.out.println(playerService + " : studentService");
            System.out.println(playerModel.getName() + " - " + playerModel.getJerseyNo()); // value present during spring container initialization
            playerModel.setName("Rohit"); // value changed during runtime
            playerModel.setJerseyNo(5); // // value changed during runtime
            playerService.display(playerModel);
            return "SUCCESS";
        }catch (Exception e){
            return "FAILURE";
        }
    }

    @GetMapping("/showName")
    public String getName(){  // API -> Application Programming Interface
        try {
            System.out.println(playerService + " : studentService");
       //     Student s1 = new Student();
            return playerModel.getName()+ " : "+String.valueOf(playerModel.getJerseyNo());
        }catch (Exception e){
            return "FAILURE";
        }
    }

    @GetMapping("/showDetails")
    public String getAllInfo(){  // API -> Application Programming Interface
        try {
            List<PlayerModel> playerModels = new ArrayList<>();
            playerModels.add(new PlayerModel(1,"Rohit Sharma", 45));
            playerModels.add(new PlayerModel(2,"Virat Kohli", 18));
            playerModels.add(new PlayerModel(3,"Rahul Dravid",24));
            playerModels.add(new PlayerModel(4,"Sourav Ganguly", 04));
            playerModels.add(new PlayerModel(5,"MS Dhoni", 07));
            return "student_details";
        }catch (Exception e){
            return "FAILURE";
        }
    }
}
