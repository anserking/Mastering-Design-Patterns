/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author SHAH
 */





abstract class Cheese{
    
    String name;

    public Cheese(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    
}

class Mozzarella extends Cheese{
    
    public Mozzarella() {
        super("Mozzarella Cheese");
    }
    
 
    
}

class Cheddar extends Cheese {
    public Cheddar() {
        super("Cheddar Cheese");
    }
}
abstract class CheeseFactory{
    
    abstract Cheese createCheese(String type);
    
}

class AnserKingFactory extends CheeseFactory{

    @Override
    Cheese createCheese(String type) {
        return switch (type.toLowerCase()) {
            case "mozzarella" -> new Mozzarella();
            case "cheddar" -> new Cheddar();
            default -> null;
        };
    }

    
    
    
    
    
}

public class SimpleFactory {
    
    public static void main(String[] args) {
        CheeseFactory factory = new AnserKingFactory();
        
        Cheese myCheese = factory.createCheese("mozzarella");
        if (myCheese != null) {
            System.out.println("Created: " + myCheese.toString());
        }
    }
    
}
