package LLD.week01.Prac;
/*
Question:  Notification System

Requirement (simple, real-world)
When a user registers, we want to send a notification via:
- Email
- SMS
- WhatsApp (future)

✅ We should be able to add new notification types without changing existing working code.

 */
//domain modal
class User{
     String name;
     String age;

 public User(String age, String name) {
  this.age = age;
  this.name = name;
 }
}

class CreateUser{
 void create(User user){
   System.out.println("user created");
 }
}
class UserRepository{
 void save(User user){
  System.out.println("User data saved to db");
 }
}

interface Notification {
 void notify(User user);
}


class UserService{
 CreateUser createUser =new CreateUser();
 UserRepository userRepository =new UserRepository();

 void register(User user){
  createUser.create(user);
  userRepository.save(user);
 }
}

public class Prac {
}
