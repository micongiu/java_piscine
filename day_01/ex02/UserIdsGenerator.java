package day_01.ex02;

// The UserIdsGenerator class is a singleton that generates unique user identifiers.
// It ensures that only one instance of the generator exists to prevent duplicate IDs.

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
