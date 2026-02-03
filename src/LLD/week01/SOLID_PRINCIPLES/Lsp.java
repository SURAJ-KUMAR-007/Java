package LLD.week01.SOLID_PRINCIPLES;

/*
Final mental rule to remember (write this in your notes 📝)
--1.{If a method does not apply to all subclasses, it does not belong in the parent — extract an interface.}-------------
--2.{If a subclass must say “I can’t do that”, the method does not belong in the parent.}------------------
--3.{If behavior is optional, model it as an interface — not in the base class.}-------------

Definition: Liskov Substitution Principle says that any subclass should be replaceable for its parent class without breaking the program behavior.
In practice, I check whether a child class can fully honor the parent’s contract.

NOTE:"Behavior that is not common to all children must NOT be in the parent."
if the behavior exists, but it’s optional, not universal → move it to an interface.

If a subclass removes functionality, throws unsupported exceptions, or changes expected behavior, inheritance is wrong.

In such cases, I extract smaller interfaces so only classes that truly support a behavior implement it.

EX: One-Line Interview Killer Example
If interviewer asks “give example”, say this 👇

“If Bird has fly() and Penguin extends it but can’t fly,
replacing Bird with Penguin breaks behavior — that violates LSP.
The fix is to separate Flyable behavior.”

---------------------------------------------------------------------
🧠 The one-line thinking rule I use: “If I replace a parent with its child, nothing should break.”
Key idea:“If child must change parent behavior → inheritance is wrong.”

----------------------------------------------------------------------

🔍 Step-by-step thinking process (what happens in my head)
1)Imagine you already have this:
class Bird {
    void fly() {
        System.out.println("Bird flying");
    }
}
2)Then someone says:
“Hey, Penguin is also a Bird.”

class Penguin extends Bird {
}

3)Now I pause and ask one deadly question:
👉 Can Penguin honestly do everything Bird promises?
- Bird promises fly()
- Penguin cannot fly

🚨 Boom — LSP violation detected.

So the steps come naturally:

- Identify the base class contract
       What behaviors does the parent promise?

- Check each child
        Can the child fully honor that contract?

- If not → inheritance is wrong
        Extract a smaller abstraction

That’s how those steps are born — not from theory, but from asking replacement questions.

---------------------------------------
✅ LSP Thinking Checklist (use this always)

Ask these 4 questions:

- Can child be used wherever parent is used?
- Does child remove or weaken parent behavior?
 -Does child throw “unsupported” exceptions?
- Does child change expected behavior?

If any answer is YES ❌ → LSP is broken.

-----------------------------------------
🔥 Mini Code Example (Java – practical)

❌ Wrong (LSP broken)

class Account {
    void withdraw(double amount) {
        System.out.println("Money withdrawn");
    }
}

class FixedDepositAccount extends Account {
    @Override
    void withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw before maturity");
    }
}

👉 Ask yourself: Can FD Account replace Account safely? ❌

✅ Correct (LSP followed)
interface Withdrawable {
    void withdraw(double amount);
}

class SavingsAccount implements Withdrawable {
    public void withdraw(double amount) {
        System.out.println("Money withdrawn");
    }
}

class FixedDepositAccount {
    // No withdraw at all
}

💡 Key thinking shift:
        “If behavior is optional → it should not be in the parent.”



* */

//Correct Design
//✅ Step 1: Minimal base abstraction
interface Vehicle{
    public void move();
}
//✅ Step 2: Optional behavior as separate interface
interface EnginePowered{
    void startEngine();
}
//✅ Step 3: Implement only where valid
class Car implements Vehicle,EnginePowered{
    @Override
   public void move(){
        System.out.println("Car is moving");

    }
    @Override
    public void startEngine() {
        System.out.println("Engine Started");

    }
}
class Bicycle implements Vehicle{
    @Override
    public void move(){
        System.out.println("Bicycle is moving");
    }
}

/*🚀 LSP preserved : Any Vehicle reference works safely.
“startEngine() should not be in Vehicle because not all vehicles have engines.
That would violate LSP when substituting Bicycle or Scooter.
I’d extract it into a separate interface like EnginePowered and let only valid classes implement it.”

-------------------------------------------------------------------
Q) Interview Follow-up Trap (they may ask this)
❓ “But ElectricScooter also has a motor. Should it implement EnginePowered?”

Best response:
“Only if the abstraction truly fits.
If semantics differ, I’d use a more generic interface like PowerSource or MotorPowered instead of forcing inheritance.”

Above statement is ezy language:
"“I choose abstractions based on real-world meaning.
If two classes behave similarly but mean different things, I use a more generic interface instead of forcing inheritance.”"


🔥 That shows semantic modeling, not just coding.
*/











public class Lsp {
}


/* --------------⚠️ Tricky LSP Case (Looks Correct, But Isn’t)----------

* Tricky LSP interview question where inheritance looks correct but still breaks LSP.
->Problem Setup (Java)

class Rectangle {
    protected int width;
    protected int height;

    void setWidth(int w) {
        width = w;
    }
    void setHeight(int h) {
        height = h;
    }
    int area() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    void setWidth(int w) {
        width = w;
        height = w;
    }
    @Override
    void setHeight(int h) {
        width = h;
        height = h;
    }
}
🚨 Where LSP Breaks (Subtle!)
void process(Rectangle r) {
    r.setWidth(5);
    r.setHeight(4);
    System.out.println(r.area());
}

Expected behavior (Rectangle contract):Area = 20
Actual behavior (Square):Area = 16 ❌

💥 Nothing crashed.
💥 No exception.
💥 But behavior changed.

👉 This is a classic LSP violation.
---------------------------------------------------------------------
🔑 Why This Violates LSP (Key Insight)
LSP is not only about:
- exceptions ❌
- missing methods ❌

It’s also about:
- Preserving behavior & expectations
Rectangle promises:
- Width and height are independent
Square silently breaks that promise.
--------------------------------------------------------------------------
✅ Correct Design (Interview-Approved)
Option 1: Remove inheritance

interface Shape {
    int area();
}

class Rectangle implements Shape {
    private int width, height;

    Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int area() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    Square(int side) {
        this.side = side;
    }

    public int area() {
        return side * side;
    }
}

💡 Key idea: “If child must change parent behavior → inheritance is wrong.”
---------------------------------------------------------------
NOTE:
“Even if Square is mathematically a Rectangle,
it violates LSP in OOP because Rectangle allows independent width and height changes.
When Square overrides setters to keep sides equal, it breaks the expected behavior.
The correct approach is to extract a common interface like Shape instead of inheritance.”

-----------------------------------------------------------------------
🧠 Your LSP Detection Formula (Memorize This)
   """If a subclass strengthens constraints or weakens guarantees of the parent → LSP is violated."""
Square strengthens constraints → width must equal height.
* */