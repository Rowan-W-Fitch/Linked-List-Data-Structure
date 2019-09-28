
public class Playlist extends java.lang.Object {
	
	Song head;

	public Playlist() {
		
	}
	
	public void insertSong(String name) {
		// inserts song at end of playlist
		// look for node that points to null
		// make last node point to the song being inserted
		
		Song insertedSong = new Song(name);

		if(this.head == null) {
			this.head = insertedSong;
			this.head.next = null;
			return;
		} //first checks if playlist is empty
		
		Song currentSong = head;
		
		while(currentSong.next != null) {
			currentSong = currentSong.next;
			//this while loop goes thru the songs in the linked list
			//stops at the last song
		}
		
		currentSong.next = insertedSong;
		insertedSong.next = null;
		//the last song in the linked list has its .next variable set to inserted song
		//inserted song.next = null
	}
	
	public void insertSong(String name, int pos) {
		
		// first check to see if index is out of bounds
		Song Songcurrent = this.head;
		int counter = 0;
		while(Songcurrent.next != null) {
			Songcurrent = Songcurrent.next;
			counter ++;
		}
		if(counter < pos) {
			throw new IndexOutOfBoundsException();
			//if the entire linked list has been run thru
			//and the position counter is less than the pos
			//then the pos is out of index
		}
		
		Song insertedSong = new Song(name);
		int position = 0; // counter for position of each song in linked list, position 0 is head
		
		if(pos == 0) {
			insertedSong.next = this.head;
			this.head = insertedSong;
			return;
		} //if the new song is placed at the beginning of the linked list
		
		Song currentSong = this.head;
		
		while(currentSong != null && position != pos - 1) {
			currentSong = currentSong.next;
			position ++;
			//goes thru each song in linked list & incr counter
			//stops when position reaches pos -1
			
		}
		
		Song old_nxt = currentSong.next; //variable that holds the current songs next link
		currentSong.next = insertedSong; //replaces currentSong next link w target song
		insertedSong.next = old_nxt; //links rest of list w inserted song
		
		
		while(currentSong.next != null) {
			currentSong = currentSong.next;
			position ++;
		}

	}
	
	public String getSong(int pos) {
		
		String str = ""; //initial string to be returned
		
		// returns name of song at pos
		// return song.name
		
		// first check to see if index is out of bounds
		Song Songcurrent = this.head;
		int counter = 0;
		while(Songcurrent.next != null) {
				Songcurrent = Songcurrent.next;
				counter ++;
			}
		if(counter < pos) {
			throw new IndexOutOfBoundsException();
			//if the entire linked list has been run thru
			//and the position counter is less than the pos
			//then the pos is out of index
			}
		
		int position = 0; // position counter
		
		if(pos == 0) {
			str = this.head.name;
			return str;
			// if pos == 0; then the target song is the head
		}
		
		Song currentSong = this.head; // current song intializer
		
		while(currentSong != null && position != pos) {
			currentSong = currentSong.next;
			position ++;
			//goes thru list up to song before target song
		}
		
		str = currentSong.name; //current song is now target song;
	
		return str;
	}
	
	public void clearPlaylist() {
		
		while(this.head != null) {
			this.head = this.head.next;
			//sets head to the next node until the head is set to null
		}
		
		// deletes all songs from playlist
	}
	
	public int size() {
		// returns # of songs in playlist
		
		int num_songs = 0; //number of songs initializer
		Song currentSong = this.head; // current song initializer
		
		//first check if list is empty
		if(head == null) {
			return num_songs;
		}
		
		while (currentSong != null) {
			num_songs ++;
			currentSong = currentSong.next;
			//goes thru list and incr num_songs at each song
		}
		
		return num_songs;
	}
	
	public void removeSong(int pos) {
		
		// first check to see if index is out of bounds
		Song Songcurrent = this.head;
		int counter = 0;
		while(Songcurrent.next != null) {
			Songcurrent = Songcurrent.next;
			counter ++;
		}
		if(counter < pos) {
			throw new IndexOutOfBoundsException();
			//if the entire linked list has been run thru
			//and the position counter is less than the pos
			//then the pos is out of index
		}
		
		int position = 0; // position intializer
		Song currentSong = this.head; //currentSong initializer
		
		if(pos == 0) {
			this.head = this.head.next;
			return;
			//if the head is the one being deleted, the head is set to the next song
			//this removes the 1st song in the link
		}
		
		while(currentSong != null && position != pos -1) {
			currentSong = currentSong.next;
			position ++;
			//goes thru songs and incr position counter
			//stops at song before target song
		}
		
		if(currentSong.next.next == null) {
			currentSong.next = null;
			return;
			//if target song is last in list it is set to null
		}
				
		currentSong.next = currentSong.next.next;
		return;
		//skips over target song effectively deleting it

	}
	
	public boolean removeSong(String name) {
		boolean bool = false; //boolean initializer	
		Song currentSong = this.head; //currentSong initializer
		
		if(this.head.name == name) {
			this.head = this.head.next;
			bool = true;
			return bool;
			//if the target song is the head, the head is set to the next song in the list
			//this deletes the original head
			//boolean value set to true
		}
		
		if(currentSong.next == null) {
			return bool;
			//checks if the next value is null
			//if so then value is not in list
		}
		
		while(currentSong != null && currentSong.next.name != name) {
			currentSong = currentSong.next;
			//goes thru song as long as the song.nxt isnt the target song and nxt song isnt null
		}
		
		//currentSong is now song before target song
		
		currentSong.next = currentSong.next.next;
		bool = true;
		//if the next song in the list is the target song
		//then the next song skips target song
		//this deletes the target song, boolean variable also set to true
			
		return bool;
	}
	
	public boolean contains(String name) {
		//returns true if atleast one song.name == String name
		boolean contain = false; //initial boolean value
		
		if(this.head.name == name) {
			contain = true;
			return contain;
			// if statement checks if the target song is the head
		}
		
		Song currentSong = this.head; //current song initializer
		
		while(currentSong != null) {
			
			if(currentSong.name == name) {
				contain = true;
				return contain;
				//if currentSong.name = name then list contains song
			}
			
			currentSong = currentSong.next;
		}
		
		return contain;
	}
	
	public String toString() {
		
		String str = "";
		// intial string
		
		if(this.head == null) {
			return str;
			//checks if playlist is empty
		}
		
		Song currentSong = head; //currentSong intializer
		
		while(currentSong.next != null) {
			str = str + currentSong.name + "->";
			currentSong = currentSong.next;
			//goes thru songs in linked list
			//adds song name and arrow at each node
		}
		
		str = str + currentSong.name;
	
		return str;
		// returns string representation of playlist
		// song1 -> song2 -> etc...
	}
	
	public String toHTMLString() {
		
		String str = "<html>PlayList<br/>";
		//initial string
		
		Song currentSong = this.head; //currentSong intializer
		
		while(currentSong != null) {
			str = str + currentSong.name + "<br/>";
			currentSong = currentSong.next;
			//goes thru all songs and adds song name + html break to string
		}
		
		
		str = str + "</html>";
		//adds end line to html string
		return str;
		
		// returns html version of string
		// <html>PlayList<br/>song1<br/>song2<br/></html>
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
