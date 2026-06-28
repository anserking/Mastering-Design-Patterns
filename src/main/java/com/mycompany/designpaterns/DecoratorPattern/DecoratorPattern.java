/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designpaterns.DecoratorPattern;

/**
 *
 * @author SHAH
 */
abstract class PizzaDecorator extends Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

}
abstract class Pizza {

    public abstract int getCost();

}


class MargeritaPizza extends Pizza {

    public int getCost(){
        return 20;
    }

}
class ExtraCheese extends PizzaDecorator {


    public ExtraCheese(Pizza pizza){
        super(pizza);
    }


    @Override
    public int getCost(){
        return pizza.getCost() + 10;
    }

}
class PineappleTopping extends PizzaDecorator {


    public PineappleTopping(Pizza pizza){
        super(pizza);
    }


    @Override
    public int getCost(){
        return pizza.getCost() + 20;
    }

}
public class DecoratorPattern {
    
    public static void main(String[] args){
        
        Pizza AnserPizza = new MargeritaPizza();

        System.out.println(AnserPizza.getCost());

        AnserPizza = new ExtraCheese(AnserPizza);

        System.out.println(AnserPizza.getCost());
        
        AnserPizza = new PineappleTopping(AnserPizza);
        System.out.println(AnserPizza.getCost());
    }
    
    
}
