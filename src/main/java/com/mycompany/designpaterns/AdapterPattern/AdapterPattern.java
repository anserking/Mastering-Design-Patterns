/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designpaterns.AdapterPattern;

/**
 *
 * @author SHAH
 */
interface I_USB_C_Charger{
    
    public void FastCharger();
    
}

class phone{
    
    private I_USB_C_Charger Charger;

    public phone(I_USB_C_Charger Charger) {
        this.Charger = Charger;
    }
    
    public void PhoneCharge(){
        Charger.FastCharger();
    }
}

class Watt50Charger implements I_USB_C_Charger{

    @Override
    public void FastCharger() {
        System.out.println("Phone is Charging Fast");
    }
    
    
    
}
class USBASlowCharger{
    
    public void SlowCharger(){
        System.out.println("Slow Charging");
    }
    
}
class USBAtoC implements I_USB_C_Charger{

    USBASlowCharger charger;

    public USBAtoC(USBASlowCharger charger) {
        this.charger = charger;
    }
    
    @Override
    public void FastCharger() {
       charger.SlowCharger();
    }
    
    
    
}






public class AdapterPattern {
    public static void main(String[] args){
        
        
        USBASlowCharger SlowCharger = new USBASlowCharger();
        USBAtoC adapter = new USBAtoC(SlowCharger);
        Watt50Charger FastCharger = new Watt50Charger();
        phone Nokia = new phone(adapter);
        phone Samsung = new phone(FastCharger);
        Nokia.PhoneCharge();
        Samsung.PhoneCharge();
           
        
        
    }
}
