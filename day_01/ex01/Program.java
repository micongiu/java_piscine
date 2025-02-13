package day_01.ex01;

// The Program class demonstrates the creation of User objects and displays their information.
// It showcases the use of the UserIdsGenerator to ensure unique user identifiers.

public class Program {
	public static void main(String[] args) {
		User user1 = new User("Alice", 100);
		User user2 = new User("Bob", 50);
		User user3 = new User("Charlie", 200);

		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
	}
}
