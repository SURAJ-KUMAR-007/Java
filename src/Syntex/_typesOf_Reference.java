package Syntex;

// ✅ Interface defining behavior for all Animals
interface Animal {
    void makeSound();  // abstract method
}

// ✅ Superclass with common functionality for pets
class Pet {
    void sleep() {
        System.out.println("Syntex.Pet is sleeping...");
    }
}

// ✅ Syntex.Dog is a subclass of Syntex.Pet and also implements Syntex.Animal interface
class Dog extends Pet implements Animal {

    // Implementing interface method
    public void makeSound() {
        System.out.println("Syntex.Dog barks");
    }

    // Method specific only to Syntex.Dog class
    void fetch() {
        System.out.println("Syntex.Dog is fetching...");
    }
}

/*
✅ What is a Reference in Java?

    In Java, a reference is a variable that points to (or refers to)
    an object in memory, rather than holding the actual object value itself.

    Example:
        Syntex.Dog d = new Syntex.Dog();

    - 'Syntex.Dog' is the **class name** and also the **data type** of the reference variable.This variable will refer to an object of type Syntex.Dog.
    - 'd' is the reference variable.
    - 'new Syntex.Dog()' creates an object in the heap memory.
    - 'd' holds the internal memory address pointing to that object.

📌 Note:
    You never deal directly with memory addresses in Java —
    the Java Virtual Machine (JVM) handles that internally.



| Reference Type | Object Type |                                  Can Access                            |
| -------------- | ----------- | ---------------------------------------------------------------------- |
| Syntex.Dog dog1       | Syntex.Dog         | All methods (makeSound(), sleep(), fetch())                            |
| Syntex.Pet dog2       | Syntex.Dog         | Only methods defined in Syntex.Pet (sleep() only (from superclass))           |
| Syntex.Animal dog3    | Syntex.Dog         | Only methods defined in Syntex.Animal {makeSound() only (from interface)}     |

This is runtime polymorphism: the method executed depends on the object type, even though the reference type may be different.
*/

public class _typesOf_Reference {
    public static void main(String[] args) {

        // 🔹 1. Class-type reference:
        // Reference and object both are Syntex.Dog
        Dog dog1 = new Dog();
        dog1.makeSound(); // ✅ Accesses interface method
        dog1.sleep();     // ✅ Inherited from Syntex.Pet
        dog1.fetch();     // ✅ Specific to Syntex.Dog class

        // 🔹 2. Superclass-type reference:
        // Reference is of superclass Syntex.Pet, object is Syntex.Dog
        Pet dog2 = new Dog();
        dog2.sleep();     // ✅ Can access method from Syntex.Pet
        // dog2.makeSound(); ❌ Not allowed — makeSound() is not in Syntex.Pet
        // dog2.fetch();     ❌ Not allowed — fetch() is not in Syntex.Pet

        // 🔹 3. Interface-type reference:
        // Reference is of interface Syntex.Animal, object is Syntex.Dog
        Animal dog3 = new Dog();
        dog3.makeSound(); // ✅ Can access interface method
        // dog3.sleep();     ❌ Not allowed — sleep() is not in Syntex.Animal
        // dog3.fetch();     ❌ Not allowed — fetch() is not in Syntex.Animal
    }
}
