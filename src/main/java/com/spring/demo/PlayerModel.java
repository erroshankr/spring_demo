package com.spring.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //registers the class in the spring container
public class PlayerModel {
    /**
     * <bean id= "std" class= "com.spring.demo.Student>
     *    <property name="name" value = "Roshan"/> // calls setter method
     *    <property name="rollNo" value = "10"/> // calls setter method
     * </bean>
     */
    @Value("${player.name: Roshan}")
    private String name;
    @Value("${player.rollNo: 10}")
    private int jerseyNo;

    private int playerID;

    public PlayerModel(int id,String name, int jerseyNo) {
        this.name = name;
        this.jerseyNo = jerseyNo;
        this.playerID=id;
    }

    public PlayerModel(String name, int jerseyNo) {
        this.name = name;
        this.jerseyNo = jerseyNo;
    }

    public PlayerModel(){

    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }
}
