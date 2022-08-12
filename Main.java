import java.util.*;

public class Main {
    /*creating an arraylist with the name as albums */

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

    /* created an object named as album */

        Album album = new Album("Akautski1","Thaman");

    /*adding some songs to this album */

        album.addSong("buttabomma",4.5);
        album.addSong("srivalli",3.5);
        album.addSong("julayi",5.0);

     /*now adding this album to albums arraylist */
        albums.add(album);

    /*creating another album with another name and another artist */
        album = new Album("Akautski2","Rehman");

    /*adding some songs in the above album */
        album.addSong("gandhapugaalini",4.5);
        album.addSong("priyaaa",3.5);
        album.addSong("columbus",4.5);

    /*now adding this album to albums arraylist */
        albums.add(album);

    /*create a linkedlist and add favourite songs in that playlist */
        LinkedList<Song> playList_1 = new LinkedList<>();
    
    /*we are getting some songs from the albums arraylist and addding it to playlist  */
        albums.get(0).addToPlayList("buttabomma",playList_1);
        albums.get(0).addToPlayList("srivalli",playList_1);
        albums.get(1).addToPlayList("gandhapugaalini",playList_1);
        albums.get(1).addToPlayList("priyaaa",playList_1);


    /*now we shouls use play method call of the above playlist */
        play(playList_1);

    }

    /*created a play method for the playlist */

    private static void play(LinkedList<Song> playList) {
        try {
            try (Scanner sc = new Scanner(System.in)) {
                boolean quit = false;
                boolean forward = true;
                ListIterator<Song> listIterator = playList.listIterator();

                if (playList.size() == 0) {
                    System.out.println("This playlist have no song");
                } else {
                    System.out.println("Now playing " + listIterator.next().toString());
                    printMenu();
                }

                while (!quit) {
                    int action=0;
                   do {
                       System.out.println("Please enter a valid input (0-6) : ");
                        action = sc.nextInt();
                   }while(action<0 || action > 6);
                    sc.nextLine();

                    switch (action) {

                        case 0:
                            System.out.println("Playlist complete");
                            quit = true;
                            break;

                        case 1:
                            if (!forward) {
                                if (listIterator.hasNext()) {
                                    listIterator.next();
                                }
                                forward = true;
                            }
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                            } else {
                                System.out.println("no song availble, reached to the end of the list");
                                forward = false;
                            }
                            break;
                        case 2:
                            if (forward) {
                                if (listIterator.hasPrevious()) {
                                    listIterator.previous();
                                }
                                forward = false;
                            }
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            } else {
                                System.out.println("we are the first song");
                                forward = false;
                            }
                            break;

                        case 3:
                            if (forward) {
                                if (listIterator.hasPrevious()) {
                                    System.out.println("Now playing " + listIterator.previous().toString());
                                    forward = false;
                                } else {
                                    System.out.println("we are at the start of the list");
                                }
                            } else {
                                if (listIterator.hasNext()) {
                                    System.out.println("now playing " + listIterator.next().toString());
                                    forward = true;
                                } else {
                                    System.out.println("we have reached to the end of list");
                                }
                            }
                            break;

                        case 4:
                            printList(playList);
                            break;
                        case 5:
                            printMenu();
                            break;
                        case 6:
                            if (playList.size() > 0) {
                                listIterator.remove();
                                if (listIterator.hasNext()) {
                                    System.out.println("now playing " + listIterator.next().toString());
                                } else {
                                    if (listIterator.hasPrevious())
                                        System.out.println("now playing " + listIterator.previous().toString());
                                }
                            }

                    }
                }
            }
        } catch (Exception e) {System.out.println(" You have entered invalid intput");}
    }

    /*printing the menu which should visible to the user */

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    /*iterator which will iterates through the playlist and checks if it has next song or not */
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}