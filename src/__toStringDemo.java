public class __toStringDemo {
     /*
     ✅ What is toString() in Java?
     ->toString() is a method defined in the Object class, which is the parent of all Java classes.It returns a String representation of an object.
     ->"Everything in Java is an object, and every object can describe itself as a string."
      * Default toString() method in java.lang.Object looks like this:
          ```
              public String toString() {
                    return getClass().getName() + "@" + Integer.toHexString(hashCode());
               }
               RETURNS : ClassName@HexadecimalHashCode
          ```
     */


        public static void main(String[] args) {
            // Without overriding toString()
            UserWithoutToString u1 = new UserWithoutToString("Alice", 25);
            System.out.println("Without toString(): " + u1); // Prints class name + hashcode

            // With overriding toString()
            UserWithToString u2 = new UserWithToString("Bob", 30);
            System.out.println("With toString(): " + u2); // Prints meaningful output

            // List of users
            System.out.println("\nUsing toString() in a list:");
            java.util.List<UserWithToString> users = new java.util.ArrayList<>();
            users.add(new UserWithToString("Charlie", 22));
            users.add(new UserWithToString("Diana", 28));
            System.out.println(users);

            java.util.List<UserWithoutToString> user = new java.util.ArrayList<>();
            user.add(new UserWithoutToString("Charlie", 22));
            user.add(new UserWithoutToString("Diana", 28));
            System.out.println(user); // List and User's toString() will be called
        }
    }

    // Class without toString() override
    class UserWithoutToString {
        private String name;
        private int age;

        public UserWithoutToString(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // Class with toString() override
    class UserWithToString {
        private String name;
        private int age;

        public UserWithToString(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Overriding toString()
        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + "}";
        }
    }

