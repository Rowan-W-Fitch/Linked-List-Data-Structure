
public class Song extends java.lang.Object {
	
	String name;
	Song next;
	
	public Song() {
	
	}
	
	public Song(String Name) {
		this.name = Name;
		// constructor that sets specific name
	}
	
	public Song(String Name, Song nxt) {
		this.name = Name;
		this.next = nxt;
		// constructor that sets specific name and the next node
	}
}
