import java.util.ArrayList;


public class Person {
	
	private ArrayList<Integer> friends;
	private int personID;

	public Person(int id) {this.personID = id; }
	
	public void addFriend(int id){ friends.add(id); }
	
}
