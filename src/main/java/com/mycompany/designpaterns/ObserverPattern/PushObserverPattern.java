package com.mycompany.designpaterns.ObserverPattern;

import java.util.ArrayList;


interface IPushGroupChat {

    void add(IPushUser user);

    void remove(IPushUser user);

    void notifyUsers(String message, IPushUser sender);

}


interface IPushUser {

    void update(String message, IPushUser sender);

    void sendMessage(String message);

}



class PushSchoolGroup implements IPushGroupChat {

    ArrayList<IPushUser> members = new ArrayList<>();


    @Override
    public void add(IPushUser user) {
        members.add(user);
    }


    @Override
    public void remove(IPushUser user) {
        members.remove(user);
    }


    @Override
    public void notifyUsers(String message, IPushUser sender) {

        for(IPushUser user : members) {

            // don't notify sender
            if(user != sender) {
                user.update(message, sender);
            }

        }

    }

}



class PushStudent implements IPushUser {

    String name;
    PushSchoolGroup group;


    PushStudent(String name, PushSchoolGroup group) {

        this.name = name;
        this.group = group;

    }


    @Override
    public void sendMessage(String message) {

        group.notifyUsers(message, this);

    }


    @Override
    public void update(String message, IPushUser sender) {

        PushStudent student = (PushStudent)sender;

        System.out.println(
            name + " received message from "
            + student.name
            + ": "
            + message
        );

    }

}



public class PushObserverPattern {

    public static void main(String[] args) {


        PushSchoolGroup group = new PushSchoolGroup();


        IPushUser ali = new PushStudent("Ali", group);
        IPushUser ahmed = new PushStudent("Ahmed", group);
        IPushUser hassan = new PushStudent("Hassan", group);


        group.add(ali);
        group.add(ahmed);
        group.add(hassan);


        ali.sendMessage("Exam is tomorrow");

    }

}