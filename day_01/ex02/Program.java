package day_01.ex02;

// The Program class demonstrates the functionality of the UsersArrayList and related classes.
// It creates users, adds them to the list, retrieves users by ID and index, and handles potential exceptions.
public class Program {
    public static void main(String[] args) {
        UsersArrayList userList = new UsersArrayList();

        try {
            userList.addUser(new User("Alice", 100));
            userList.addUser(new User("Bob", 200));
            userList.addUser(new User("Charlie", -50)); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating user: " + e.getMessage());
        }

        userList.addUser(new User("David", 300));
        userList.addUser(new User("Eve", 400));
        userList.addUser(new User("Frank", 500));
        userList.addUser(new User("Grace", 600));
        userList.addUser(new User("Henry", 700));
        userList.addUser(new User("Ivy", 800));
        userList.addUser(new User("Jack", 900));
        userList.addUser(new User("Kelly", 1000));
        userList.addUser(new User("Liam", 1100));


        System.out.println("Number of users: " + userList.getNumberOfUsers());

        try {
            User bob = userList.getUserById(2);
            System.out.println("User with ID 2: " + bob);
            User nonExistentUser = userList.getUserById(99); // This will throw an exception
            System.out.println("This won't print"); // Because the previous line throws exception
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

        User firstUser = userList.getUserByIndex(0);
        System.out.println("User at index 0: " + firstUser);

        User userAtIndex10 = userList.getUserByIndex(10);
        System.out.println("User at index 10: " + userAtIndex10);

        System.out.println(userList.getUserById(1));

    }
}