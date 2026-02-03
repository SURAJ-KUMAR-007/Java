package LLD.week01.SOLID_PRINCIPLES;

/*
“I identified three responsibilities: registration logic, persistence, and Notification.
Since each changes for a different reason (rules/provider/DB), I separated them into individual classes.
Then I kept UserService as a thin orchestrator to coordinate the flow and keep SRP intact.”

EmailService → only email
UserRepository → only DB
UserRegistrationService → only business rules
SmsService → only SMS

Each class still has one reason to change ✅
That’s SRP in action.

*/
class User {
    String name;
    String email;

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

class UserRegistrationService {
    void register(User user) {
        System.out.println("User registered: " + user.name);
    }
}

class EmailService {
    void sendWelcomeMail(User user) {
        System.out.println("Mail sent to: " + user.email);
    }
}
class SmsService {
    void sendWelcomeSms(User user) {
        System.out.println("SMS sent to user: " + user.name);
    }
}
class UserRepository {
    void save(User user) {
        System.out.println("User saved to DB: " + user.name);
    }
}

class AuditLogger {
    void log(String action, String userName) {
        System.out.println("AUDIT -> Action: " + action
                + ", User: " + userName
                + ", Time: " + System.currentTimeMillis());
    }
}
/*Think of orchestrator like a manager in an office.
✅ Orchestrator = the class that represents the use-case flow.
-  Workers do one job each (Email, DB, Audit…)
- Manager doesn’t do the jobs
- Manager just decides the order + coordinates

Example use-case: “Register User”.

Q)What to consider when linking (the 3 rules)

✅ Rule 1: Orchestrator owns the ORDER
Only orchestrator decides:
-what happens first
-what happens next
-what happens if something fails

Workers should NOT call each other.
ex:Bad (tight coupling):
class UserRepository {
   void save(User u){
      // save...
      emailService.sendWelcomeMail(u); // ❌ wrong
   }
}
ex:Good (loose coupling):
class UserService {
   void register(User u){
      repository.save(u);
      emailService.sendWelcomeMail(u);
   }
}


✅ Rule 2: Workers should not know each other
Email service should not know DB exists.
DB should not know Email exists.
They only know their job.

✅ Rule 3: Orchestrator has “use-case” names, not technical names
Good names:
- UserOnboardingService
- RegisterUserUseCase
Not great:
- UserHelper
- CommonService
(because unclear flow)

--------------------------------------------------------------
Simple analogy to make it stick
Food delivery app example
- RestaurantService cooks food
- DeliveryPartnerService delivers
- PaymentService collects payment

Orchestrator = OrderService
It coordinates:
1.pay
2.place order
3.assign delivery
4.notify

Workers don’t call each other. OrderService coordinates.



Q)How to decide “how many orchestrators” you need?
Simple rule:
✅ 1 orchestrator per use-case (action)
Examples:
RegisterUserUseCase
LoginUserUseCase
ResetPasswordUseCase

Don’t make one orchestrator for everything.
* */
class UserService{// Use-case orchestrator
    UserRegistrationService registerService = new UserRegistrationService();
    EmailService  emailService =new EmailService();
    UserRepository repository= new UserRepository();
    SmsService smsService =new SmsService();
    AuditLogger auditLogger =new AuditLogger();
    void register(User user){
        registerService.register(user);
        auditLogger.log("USER_REGISTERED", user.name);

        repository.save(user);
        auditLogger.log("USER_SAVED",user.name);

        emailService.sendWelcomeMail(user);
        smsService.sendWelcomeSms(user);
        
        auditLogger.log("WELCOME_EMAIL_SENT",user.name);
    }
}


interface Notification {
    void notify(User user);
}
class Es implements Notification {
    @Override
    public void notify(User user) {
        System.out.println("Mail sent to: " + user.email);
    }
}
class Ss implements Notification {
    @Override
    public void notify(User user) {
        System.out.println("SMS sent to user: " + user.name);
    }
}

class NotificationService  {
    void caller(User user, Notification notification){
        notification.notify(user);
    }
}





/*Place order
*/









//-----------------Small domain models
class OrderRequest {
    String userEmail;
    String itemId;
    int qty;

    OrderRequest(String userEmail, String itemId, int qty) {
        this.userEmail = userEmail;
        this.itemId = itemId;
        this.qty = qty;
    }
}

class Order {
    String orderId;
    String status; // PENDING_PAYMENT / CONFIRMED / FAILED

    Order(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }
}
//------------------Worker services (single responsibility each)
class InventoryService {
    void reserve(String itemId, int qty) {
        System.out.println("Inventory reserved: " + itemId + " qty=" + qty);
    }
}

class OrderRepository {
    Order createPendingOrder(OrderRequest req) {
        Order order = new Order("ORD123", "PENDING_PAYMENT");
        System.out.println("Order saved: " + order.orderId + " status=" + order.status);
        return order;
    }

    void markConfirmed(Order order) {
        order.status = "CONFIRMED";
        System.out.println("Order updated: " + order.orderId + " status=" + order.status);
    }
}

class PaymentService {
    void charge(Order order) {
        System.out.println("Payment charged for order: " + order.orderId);
    }
}

class EmailServic {
    void sendOrderConfirmation(String email, Order order) {
        System.out.println("Email sent to " + email + " for order " + order.orderId);
    }
}


//-----------✅ Orchestrator = PlaceOrderUseCase
/*✅ The exact “linking” idea in 1 sentence
  => Orchestrator is just a method where you write the business steps in order and call each specialized class to do its part.*/

class PlaceOrderUseCase {
    private final InventoryService inventory;
    private final OrderRepository orderRepo;
    private final PaymentService payment;
    private final EmailServic email;

    PlaceOrderUseCase(InventoryService inventory, OrderRepository orderRepo,
                      PaymentService payment, EmailServic email) {
        this.inventory = inventory;
        this.orderRepo = orderRepo;
        this.payment = payment;
        this.email = email;
    }

    void placeOrder(OrderRequest req) {
        // 1) validate/reserve stock
        inventory.reserve(req.itemId, req.qty);

        // 2) create pending order (persist state)
        Order order = orderRepo.createPendingOrder(req);

        // 3) charge payment
        payment.charge(order);

        // 4) mark confirmed + notify
        orderRepo.markConfirmed(order);
        email.sendOrderConfirmation(req.userEmail, order);
    }
}


public class Srp {
    public static void main(String[] args) {
        User user1 = new User("Suraj","surya@gmail.com");
        UserService userService = new UserService();

        NotificationService notificationService=new NotificationService();
        Es es = new Es();
        userService.register(user1);
        notificationService.caller(user1,es);


        System.out.println("\n\n\n\n");


        PlaceOrderUseCase useCase = new PlaceOrderUseCase(
                new InventoryService(),
                new OrderRepository(),
                new PaymentService(),
                new EmailServic()
        );
        useCase.placeOrder(new OrderRequest("a@b.com", "ITEM9", 2));
    }
}
