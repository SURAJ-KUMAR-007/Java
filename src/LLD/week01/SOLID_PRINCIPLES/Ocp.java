package LLD.week01.SOLID_PRINCIPLES;
//  Open-closed principle
/*
//OCP mindset (memorize this)  =>  “I should be able to add new behavior without changing existing code.”

// NOTE:   Open for extension, Closed for modification (You should add new behavior without changing existing code.)

    *Software entities should be open for extension.
    *They should be closed for modification.
    *New behavior should be added without changing existing code.
    *Prevents breaking already working logic.
    *Achieved using abstraction and polymorphism.

❌ Bad Example
    class DiscountCalculator {

        double calculate(String type, double amount) {
            if (type.equals("FESTIVAL")) {
                return amount * 0.1;
            } else if (type.equals("NEWUSER")) {
                return amount * 0.2;
            }
            return 0;
        }
    }
❌ Every new discount → modify class
❌ Risky & messy
*/

import java.util.Scanner;

//✅ Good Example (using abstraction)
interface Discount {
    double discountAmount(double amount);
}

class FestivalDiscount implements Discount {
    @Override
    public double discountAmount(double amount) {
        return amount * 0.2; // 20% discount
    }
}
class NewYearDiscount implements Discount {
    public double discountAmount(double amount) {
        return amount * 0.3;
    }
}
class FlatDiscount implements  Discount{
    @Override
    public double discountAmount(double amount) {
        return (amount >= 3000) ? 500 : 0;
    }
}
class WeekendDiscount implements Discount{
    @Override
    public double discountAmount(double amount){
        return amount * 0.1;
    }
}
/*
 - DiscountService does NOT change
 - New discounts are added by creating new classes  ex: NewYearDiscount
 - No change in DiscountService 🚀

        That’s OCP done right.
 */
class DiscountService {
    double finalPrice(double  amount, Discount... discounts){
        double totalDiscounts=0;
        for (Discount d:discounts){
            totalDiscounts+=d.discountAmount(amount);
        }
        return amount- totalDiscounts;
    }
}


public class Ocp {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        double finalAmount=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount :");
        double amount = scanner.nextInt();
        // ✅ create object
        Discount festivalDiscount = new FestivalDiscount();
        Discount flatDiscount = new FlatDiscount();

       finalAmount = discountService.finalPrice(amount,festivalDiscount,flatDiscount);


        System.out.println(finalAmount);
    }
}

/* Example 2
* Interview-ready explanation (this is gold)
“Instead of using conditionals, I introduced a NotificationService abstraction.
New notification types can be added by implementing the interface without modifying existing logic, which follows Open–Closed Principle.”
* */