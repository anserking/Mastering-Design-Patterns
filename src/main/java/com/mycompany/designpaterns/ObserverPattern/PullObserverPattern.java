/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designpaterns.ObserverPattern;

import java.util.ArrayList;

/**
 *
 * @author SHAH
 */

interface IGroupChat{
    
    public void add(IUser u);
    public void remove(IUser u);
    public void notifyUser();
    
}
interface  IUser{
    
    public void  update();
    
    
}
class SchoolGroup implements IGroupChat{
    ArrayList<IUser> Members = new ArrayList();
    @Override
    public void add(IUser u) {
        Members.add(u);
    }

    @Override
    public void remove(IUser u) {
        Members.remove(u);
    }

    @Override
    public void notifyUser() {
        for(IUser user : Members){
        user.update();
    }
    }
    
    
    
}
class Student implements IUser {

    String name;

    Student(String name){
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " received notification");
    }
    
    
}



public class PullObserverPattern {
    public static void main(String[] args){
        
        SchoolGroup group = new SchoolGroup();

        IUser ali = new Student("Ali");
        IUser ahmed = new Student("Ahmed");

        group.add(ali);
        group.add(ahmed);

        group.notifyUser();
        
    }
}
