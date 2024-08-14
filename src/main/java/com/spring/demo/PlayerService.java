package com.spring.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayerService {

    /**
     * <bean id="studentService" class = "com.spring.demo.StudentService>
     *  </bean>
     *
     */
    public void display(PlayerModel st){
        System.out.println(st + " : student");
        System.out.println(st.getName() + " - " + st.getJerseyNo());
        System.out.println(st + " : student");

    }
}
