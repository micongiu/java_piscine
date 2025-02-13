package day_01.ex02;

import java.util.Arrays;

// UsersArrayList implements the UsersList interface and stores users in an array.
// It dynamically resizes the array when it becomes full.
public class UsersArrayList implements UsersList {
	private User[] users;
	private int size;
	private int capacity;

	// Constructs a new UsersArrayList with an initial capacity of 10.
	public UsersArrayList() {
		capacity = 10;
		users = new User[capacity];
		size = 0;
	}

	@Override
	public void addUser(User newUser) {
		if (size == capacity) {
			capacity = capacity + (capacity / 2);
			users = Arrays.copyOf(users, capacity);
		}
		users[size++] = newUser;
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		for (int i = 0; i < size; i++) {
			if (users[i].getIdentifier() == id) {
				return users[i];
			}
		}
		throw new UserNotFoundException("User with ID " + id + " not found.");
	}

	@Override
	public User getUserByIndex(int index) {
		if (index >= 0 && index < size) {
			return users[index];
		}
		return null;
	}

	@Override
	public int getNumberOfUsers() {
		return size;
	}
}