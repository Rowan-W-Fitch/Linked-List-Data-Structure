
public class PlayList_Tester {
	
	public static void main(String[] args) {
		
		Playlist tester = new Playlist(); //creates playlist object
		
		//test the two insert song methods
		tester.insertSong("Doolin-Dalton"); //adds head to list
		tester.insertSong("James Dean"); //adds 2nd song
		System.out.println(tester.toString());
		
		tester.insertSong("Hotel California", 0); //testing 2nd method at 0 pos
		System.out.println(tester.toString());
		
		tester.insertSong("Here Comes Trouble", 1); //testing at mid list
		System.out.println(tester.toString());
		
		//tester.insertSong("FreeBird", 5); //testing out of index error message, uncomment to use
		
		//test getSong method
		System.out.println(tester.getSong(0));
		System.out.println(tester.getSong(1));
		//System.out.println(tester.getSong(5)); //testing out of index error message, uncomment to use
		
		//test clearPlaylist()
		tester.clearPlaylist();
		System.out.println(tester.toString());
		
		//test size method
		System.out.println(tester.size()); //should return 0
		
		tester.insertSong("Hail Mary");
		tester.insertSong("Lets Get High");
		tester.insertSong("Never Recover");
		tester.insertSong("Cotton Eye Joe");
		System.out.println(tester.size()); //should return 4
		
		//test removeSong methods
		System.out.println(tester.toString());
		
		tester.removeSong(3); //remove the last song (doesnt fit genre)
		System.out.println(tester.toString());
		
		tester.removeSong(1); //remove 2nd song
		System.out.println(tester.toString());
		
		//tester.removeSong(3); //test out of index error, uncomment to use
		
		tester.insertSong("A-mili"); //adding another song to end
		System.out.println(tester.toString());
		tester.removeSong("Never Recover"); //test 2nd removeSong
		System.out.println(tester.toString());
		
		System.out.println(tester.removeSong("Hail Mary")); //should print true
		System.out.println(tester.toString());
		
		System.out.println(tester.removeSong("Ohio")); //should print false
		System.out.println(tester.toString()); //should be same as before	
		
		//testing contains method
		System.out.println(tester.contains("A-mili")); //should print true
		System.out.println(tester.contains("Ohio")); //should print false
		
		//testing toHTML method
		tester.insertSong("Free Bird");
		tester.insertSong("One Love"); //adding songs to make list longer
		System.out.println(tester.toHTMLString());
	}
	
}
