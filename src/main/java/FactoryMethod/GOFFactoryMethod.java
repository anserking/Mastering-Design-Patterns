package FactoryMethod;

// GOF Product
abstract class GOFCheese {

    protected String name;

    public GOFCheese(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// GOF Concrete Product
class GOFMozzarella extends GOFCheese {

    public GOFMozzarella() {
        super("Mozzarella Cheese");
    }
}

// GOF Concrete Product
class GOFCheddar extends GOFCheese {

    public GOFCheddar() {
        super("Cheddar Cheese");
    }
}


// GOF Creator
abstract class GOFCheeseFactory {

    // GOF Factory Method
    protected abstract GOFCheese createCheese();

    public GOFCheese orderCheese() {

        GOFCheese cheese = createCheese();

        System.out.println("Preparing " + cheese);
        System.out.println("Packaging " + cheese);

        return cheese;
    }
}


// GOF Concrete Creator
class GOFMozzarellaFactory extends GOFCheeseFactory {

    @Override
    protected GOFCheese createCheese() {
        return new GOFMozzarella();
    }
}


// GOF Concrete Creator
class GOFCheddarFactory extends GOFCheeseFactory {

    @Override
    protected GOFCheese createCheese() {
        return new GOFCheddar();
    }
}


// Client
public class GOFFactoryMethod {

    public static void main(String[] args) {

        GOFCheeseFactory factory = new GOFMozzarellaFactory();

        GOFCheese cheese = factory.orderCheese();

        System.out.println("Created: " + cheese);
    }
}