public class explore {
     class Box<T>
    {
        T name;
        void set (T value){
            name=value;

        }
        T get(){
            return name;
        }
    }

        //static factory method
     static class Myclass{
         private Myclass(){
             System.out.println("Instance created");
         }
         public static Myclass createInstance(){
             return new Myclass();
         }

    }
    public static void main(String[] args) {
         explore outer = new explore();

        Box<String> boxes = outer. new Box<>();
        boxes.set("suraj");
//        System.out.println(boxes.get());

        Myclass obj = Myclass.createInstance();

    }
}
