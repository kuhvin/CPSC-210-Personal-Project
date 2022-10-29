package model;

import org.json.JSONObject;
import persistence.Writable;

//Creates an entry with name, type of media, genre, length (in minutes), year released, personal rating of out 10
//(future: perhaps option with name of lead actors/actresses)
public class FilmListEntry implements Writable {

    private String name;
    private String tom;
    private String genre;
    private int runtime;
    private int year;
    private double rating;


    /*
    Requires: all fields are filled and are not an empty strings or negative integers
    Effects: name of entry is set to mediaName, tom of entry is set to typeOfMedia, genre is set to genre, length
             set to lengthOfFilm, year is set to yearReleased, rating is set to personalRating
     */
    public FilmListEntry(String mediaName, String typeOfMedia, String genre,
                         int lengthOfFilm, int yearReleased, double personalRating) {
        this.name = mediaName;
        this.tom = typeOfMedia;
        this.genre = genre;
        this.runtime = lengthOfFilm;
        this.year = yearReleased;
        this.rating = personalRating;
    }

    /*
    Requires: sound entry
    Effects: returns a string with all criterion within in a readable format
     */
    public String getAll() {
        return (this.name + ", " + this.tom + ", " + this.genre + ". Runtime: " + this.runtime + " minutes, made in "
                + this.year + ". Rated at " + this.rating + " out of 10.");
    }

    /*
    Effects: sets keys for JSONObject
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type of media", tom);
        json.put("genre", genre);
        json.put("runtime", runtime);
        json.put("year", year);
        json.put("rating", rating);

        return json;
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
        if (newLength >= 0) {
            this.runtime = newLength;
        }
    }

    /*
    Requires: positive integer
    Modifies: this
    Effects: changes the year
     */
    public void updateYear(int newYear) {
        if (newYear >= 0) {
            this.year = newYear;
        }
    }

    /*
    Requires: positive integer from 1-10
    Modifies: this
    Effects: changes the rating
    */
    public void updateRating(double newRating) {
        if (newRating >= 0) {
            this.rating = newRating;
        }
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

    public int getRuntime() {
        return this.runtime;
    }

    public int getYear() {
        return this.year;
    }

    public double getRating() {
        return this.rating;
    }

}
