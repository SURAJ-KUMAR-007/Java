package Syntex;

public class _3_Array {

    /*
    1)First Way
      // declares an array of integers
        int[] anArray;

        // allocates memory for 10 integers
        anArray = new int[10];

        // initialize first element
        anArray[0] = 100;



    2)Second way
    // create an array of integers
        anArray = new int[10];
        anArray[0] = 100; // initialize first element

    3)Third way
    //shortcut syntax to create and initialize an array:
    int[] anArray = {
        100, 200, 300,
        400, 500, 600,
        700, 800, 900, 1000
      };

     4)multidimensional array
     String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };


    */

    /*Built in methods
    1)length
        System.out.println(anArray.length);
    2) Copying Arrays

    a)   The two Object arguments specify the array to copy from and the array to copy to.
         The three int arguments specify the starting position in the source array,
         the starting position in the destination array, and the number of array elements to copy.
         code general Syntex:
            public static void arraycopy(Object src, int srcPos,
                                 Object dest, int destPos, int length)

            ex:
                class ArrayCopyDemo {
                    public static void main(String[] args) {
                        String[] copyFrom = {
                            "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                            "Marocchino", "Ristretto" };

                        String[] copyTo = new String[7];
                        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
                        for (String coffee : copyTo) {
                            System.out.print(coffee + " ");
                            }
                         }
                    }

            b)using  java.util.Arrays methods
            **Note: that the second parameter of the java.util.Arrays method is the initial index of the range to be copied,
             inclusively, while the third parameter is the final index of the range to be copied, exclusively
            **code:
             class ArrayCopyOfDemo {
                    public static void main(String[] args) {
                        String[] copyFrom = {
                            "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                            "Marocchino", "Ristretto" };

                        String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
                        for (String coffee : copyTo) {
                            System.out.print(coffee + " ");
                        }
                    }
                }
        ***Some other useful operations provided by methods in the java.util.Arrays class are***

        a)public static int binarySearch(long[] a, int fromIndex, int toIndex, long key)
        b)public static boolean equals(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex, int bToIndex)
        c)public static void fill(int[] a, int fromIndex, int toIndex, int val)
        d)Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.
            Note:This algorithm offers O(n log(n)) performance on all data sets,
                and is typically faster than traditional (one-pivot) Quicksort implementations.
           SYNTEX :  public static void parallelSort(int[] a, int fromIndex, int toIndex)

        e)public static IntStream stream(int[] array, int startInclusive, int endExclusive)
            Parameters:array - the array, assumed to be unmodified during use
            Returns a sequential IntStream with the specified range of the specified array as its source.
            Creating a stream that uses an array as its source (the stream() method).
            For example,the following statement prints the contents of the copyTo array in
             the same way as in the previous example:
                CODE Example:
             java.util.Arrays.stream(copyTo).map(coffee -> coffee + " ").forEach(System.out::print);
        f)public static int compare(boolean[] a, int aFromIndex, int aToIndex,
                                      boolean[] b, int bFromIndex, int bToIndex)

        g)public static int mismatch(boolean[] a, int aFromIndex, int aToIndex, boolean[] b,
                                       int bFromIndex, int bToIndex)
        h)public static String toString(int[] a)
    * */

public static void main(String [] args){
/*
    int []arr= {1,2,3,4,5};

   //copy arr using system methods
    int[] copyTo = new int[5];
    System.arraycopy(arr,0,copyTo,0,5);
    for(int i:copyTo){
        System.out.println(i);
    }
    //copy array using java.util.Arrays.copyOfRange() method
    int[] usingJavaArray  = java.util.Arrays.copyOfRange(arr,1,5);
    for (int i:usingJavaArray){
        System.out.println(i);
    }

    //binary search
    int result = java.util.Arrays.binarySearch(arr,3112);
    System.out.println(result);

    //equals
    var isEqual = java.util.Arrays.equals(arr,copyTo);
    System.out.println(isEqual);

   //fill
     java.util.Arrays.fill(arr,1,5,78);
       for (int i :arr){
           System.out.println(i);
       }
  //sorting
    int[] num ={2,4,2,5,2,8,6};
    java.util.Arrays.sort(num); //using sort
    java.util.Arrays.parallelSort(num); //using parallelSort
    for (int i: num){
        System.out.println(i);
    }

    //stream
      java.util.Arrays.stream(arr).map(coffee -> coffee + 1).forEach(System.out::println);

    //toString
    String str = java.util.Arrays.toString(arr);
    System.out.println(str);
*/

}
}
