// creating  a song class

public class Song {
    private String title;
    private double duration;

    // creating a constructor for the song class

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
// create a gettitle method th get the title of the song

    public String getTitle() {
        return title;
    }

// create a getduration method th get the duration of the song

    public double getDuration() {
        return duration;
    }

    // creating a tostringmethod which will be override in the main class

    @Override
    public String toString() {
        return "song ==> title = " + title + ',' + "duration = " + duration;
    }
}
