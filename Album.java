import java.util.ArrayList;
import java.util.LinkedList;
/*creating an album class */

public class Album {
    /*creating an arraylist named as songs to maintain songs in it */

    private ArrayList<Song> songs;

    /*creating a constructor with parameters name and artist  */
    public Album(String name, String artist) {
        this.songs = new ArrayList<Song>();
    }

    /*method to find the song with the title as parameter whether song with that title name exists or not */

    public Song findSong(String title){

        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    /*if we didnt find any song then the above method return null and it will be added by the below method */

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
//            System.out.println(title + "successfully added to the list");
            return true;
        }
        else {
//            System.out.println("Song with name "+ title+ " already exist in the list");
            return false;
        }
    }

    /*now we should create an addtoplaylist method to add the songs to the playlist when we given with the tracknumber and linkedlist as the parameters*/

    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber - 1;
        if(index >= 0 && index <= songs.size()){
            PlayList.add(songs.get(index));
            return true;
        }
//        System.out.println("this album does not have song with trackNumber "+trackNumber);
        return false;
    }
  /*again we should create an addtoplaylist method to add the songs to the playlist when we given with the title and linkedlist as the parameters*/
  
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title + "there is no such song in album");
        return false;
    }
}