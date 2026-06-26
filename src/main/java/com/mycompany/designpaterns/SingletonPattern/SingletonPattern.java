/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designpaterns.SingletonPattern;

/**
 *
 * @author SHAH
 */

class Admin{
    private static Admin AnserKing;
    private Admin(){}
    
    
    public static Admin getAdmin(){
        
        if(AnserKing == null){
            AnserKing = new Admin();
        }
        
        return AnserKing;
        
    }
    @Override
    public String toString(){
        
       
        return "AnserKing is Best";
        
    }
    
}


public class SingletonPattern {
    
    public static void main(String[] args){
        
        System.out.println(Admin.getAdmin().toString()); 
          
        
    }
    
}
