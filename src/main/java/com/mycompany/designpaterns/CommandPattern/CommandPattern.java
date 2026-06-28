/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designpaterns.CommandPattern;

/**
 *
 * @author SHAH
 */

class Remote{
    
    ICommand command;
    public void setCommand(ICommand c){
        this.command = c;
    }
    public void Check() throws Exception{
        if(command == null){
            throw new Exception("Command is not Set");
        }
    }
    public void pressButton(){
        try {
            Check();
            command.execute();
        } catch (Exception ex) {
            System.out.println("Command is not SET"); 
       }
    }

    public void pressUndo() {
        try {
            Check();
            command.unexecute();
        } catch (Exception ex) {
            System.getLogger(Remote.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
}

interface ICommand{
    public void execute();
    public void unexecute();
    
}
class PowerCommand implements ICommand{

    TV tv;

    public PowerCommand(TV tv) {
        this.tv = tv;
    }
    
    
    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void unexecute() {
        tv.turnOff();
    }
    
    
    
}
class TV{
    
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
    
    
}

public class CommandPattern {
    public static void main(String[] args){
        
        TV tv = new TV();
        Remote AnserRemote = new Remote();
        PowerCommand p1 = new PowerCommand(tv);
        AnserRemote.setCommand(p1);
        AnserRemote.pressButton();
        
        
    }
}
