package day_01.ex03;

// The UserIdsGenerator class is a singleton class responsible for generating unique
// user identifiers. It uses a counter to ensure that each user gets a distinct ID.

public class UserIdsGenerator {
		private int id_counter;
		private static UserIdsGenerator instance;
	
		// Private constructor to prevent instantiation from outside the class.
		private UserIdsGenerator() {
			id_counter = 0;
		}

		// Returns the single instance of the UserIdsGenerator (Singleton pattern).
		// Creates the instance if it doesn't already exist.
		// @return The UserIdsGenerator instance.
		public static UserIdsGenerator getInstance() {
			if (instance == null) {
				instance = new UserIdsGenerator();
			}
			return instance;
		}
				
		// Generates a new unique user identifier.
		// @return The generated user identifier.
		public int generateId() {
			return ++id_counter;
		}
}

// This is a better apporch but I can't use do to the subject
// public enum UserIdsGenerator {
// 	INSTANCE;

// 	private int idCounter = 0;

// 	public int generateId() {
// 		return ++idCounter;
// 	}
// }
