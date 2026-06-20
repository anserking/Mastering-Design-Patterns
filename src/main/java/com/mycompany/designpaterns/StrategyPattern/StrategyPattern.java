/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designpaterns.StrategyPattern;

interface IBankWidhdrawBehavior{
    public void Widhdraw();
}
class BankCannotWidhdraw implements IBankWidhdrawBehavior{
    @Override
    public void Widhdraw(){
        System.out.println("Cannot Widhdraw");
    };
}
class BankCanWidhdraw implements IBankWidhdrawBehavior{
    @Override
    public void Widhdraw(){
        System.out.println("Can Widhdraw");
    };
}

abstract class BankAccount{
    IBankWidhdrawBehavior WidhrawMoney;
    public BankAccount(IBankWidhdrawBehavior WidhrawMoney) {
        this.WidhrawMoney = WidhrawMoney;
    }
    public void WidhdrawMoney(){
        WidhrawMoney.Widhdraw();
    }

}

class SavingAccount extends BankAccount{
    
    public SavingAccount() {
        super(new BankCannotWidhdraw());
    }
    
    
    
}
/**
 * 
 *
 * @author SHAH
 */
public class StrategyPattern {
    public static void main(String[] args){
    SavingAccount a1 = new SavingAccount();
   
    a1.WidhdrawMoney();
}
}