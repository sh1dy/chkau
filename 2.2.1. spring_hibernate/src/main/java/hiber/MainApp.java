package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Doctor", "Who", "К_9@gmail.com");
      user1.setCar(new Car(1963, "TARDIS"));
      userService.add(user1);

      User user2 = new User("Daniel", "Morales", "pupupu@outlook.com");
      user2.setCar(new Car(500, "Mercedes-Benz"));
      userService.add(user2);

      User user3 = new User("Headless", "Horseman", "trick@treat.com");
      user3.setCar(new Car(3110, "horse"));
      userService.add(user3);

      List<User> users = userService.listUsers();
      System.out.println();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println("\n" + userService.findUserByCar(1963, "TARDIS") + "\n");

      context.close();
   }
}
