// ✅ Interface defining behavior for all Animals
interface Animal {
    void makeSound();  // abstract method
}

// ✅ Superclass with common functionality for pets
class Pet {
    void sleep() {
        System.out.println("Pet is sleeping...");
    }
}

// ✅ Dog is a subclass of Pet and also implements Animal interface
class Dog extends Pet implements Animal {

    // Implementing interface method
    public void makeSound() {
        System.out.println("Dog barks");
    }

    // Method specific only to Dog class
    void fetch() {
        System.out.println("Dog is fetching...");
    }
}

/*
✅ What is a Reference in Java?

    In Java, a reference is a variable that points to (or refers to)
    an object in memory, rather than holding the actual object value itself.

    Example:
        Dog d = new Dog();

    - 'Dog' is the **class name** and also the **data type** of the reference variable.This variable will refer to an object of type Dog.
    - 'd' is the reference variable.
    - 'new Dog()' creates an object in the heap memory.
    - 'd' holds the internal memory address pointing to that object.

📌 Note:
    You never deal directly with memory addresses in Java —
    the Java Virtual Machine (JVM) handles that internally.



| Reference Type | Object Type |                                  Can Access                            |
| -------------- | ----------- | ---------------------------------------------------------------------- |
| Dog dog1       | Dog         | All methods (makeSound(), sleep(), fetch())                            |
| Pet dog2       | Dog         | Only methods defined in Pet (sleep() only (from superclass))           |
| Animal dog3    | Dog         | Only methods defined in Animal {makeSound() only (from interface)}     |

This is runtime polymorphism: the method executed depends on the object type, even though the reference type may be different.
*/

public class _typesOf_Reference {
    public static void main(String[] args) {

        // 🔹 1. Class-type reference:
        // Reference and object both are Dog
        Dog dog1 = new Dog();
        dog1.makeSound(); // ✅ Accesses interface method
        dog1.sleep();     // ✅ Inherited from Pet
        dog1.fetch();     // ✅ Specific to Dog class

        // 🔹 2. Superclass-type reference:
        // Reference is of superclass Pet, object is Dog
        Pet dog2 = new Dog();
        dog2.sleep();     // ✅ Can access method from Pet
        // dog2.makeSound(); ❌ Not allowed — makeSound() is not in Pet
        // dog2.fetch();     ❌ Not allowed — fetch() is not in Pet

        // 🔹 3. Interface-type reference:
        // Reference is of interface Animal, object is Dog
        Animal dog3 = new Dog();
        dog3.makeSound(); // ✅ Can access interface method
        // dog3.sleep();     ❌ Not allowed — sleep() is not in Animal
        // dog3.fetch();     ❌ Not allowed — fetch() is not in Animal
    }
}
