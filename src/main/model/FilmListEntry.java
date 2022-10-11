package model;

public class FilmListEntry {
    //Creates an entry with name, type of media, genre, length (in minutes), year released, personal rating of out 10
    //(future: perhaps option with name of lead actors/actresses)

    private String name;
    private String tom;
    private String genre;
    private int length;
    private int year;
    private int rating;


    /*
    Requires: all fields are filled and are not an empty strings or negative integers
    Effects: name of entry is set to mediaName, tom of entry is set to typeOfMedia, genre is set to genre, length
             set to lengthOfFilm, year is set to yearReleased, rating is set to personalRating
     */
    public FilmListEntry(String mediaName, String typeOfMedia, String genre,
                         int lengthOfFilm, int yearReleased, int personalRating) {
        this.name = mediaName;
        this.tom = typeOfMedia;
        this.genre = genre;
        this.length = lengthOfFilm;
        this.year = yearReleased;
        this.rating = personalRating;
    }

    /*
    Requires: non-empty string
    Modifies: this
    Effects: changes the name to new desired name
     */
    public void updateName(String newName) {
        this.name = newName;
    }

    /*
    Requires: non-empty string
    Modifies: this
    Effects: changes the type of media
     */
    public void updateType(String newType) {
        this.tom = newType;
    }

    /*
    Requires: non-empty string
    Modifies: this
    Effects: changes the genre
     */
    public void updateGenre(String newGenre) {
        this.genre = newGenre;
    }

    /*
    Requires: positive integer
    Modifies: this
    Effects: changes length in minutes
     */
    public void updateLength(int newLength) {
        this.length = newLength;
    }

    /*
    Requires: positive integer
    Modifies: this
    Effects: changes the year
     */
    public void updateYear(int newYear) {
        this.year = newYear;
    }

    /*
    Requires: positive integer from 1-10
    Modifies: this
    Effects: changes the rating
    */
    public void updateRating(int newRating) {
        this.rating = newRating;
    }


    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.tom;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getLength() {
        return this.length;
    }

    public int getYear() {
        return this.year;
    }

    public int getRating() {
        return this.rating;
    }

}
