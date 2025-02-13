package day_01.ex02;

// The UsersList interface defines the contract for classes that store and manage users.
interface UsersList {
	void addUser(User newUser);

	User getUserById(int id) throws UserNotFoundException;

	User getUserByIndex(int index);

	int getNumberOfUsers();
}