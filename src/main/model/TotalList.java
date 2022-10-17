package model;

import java.util.ArrayList;

public class TotalList {
    //Either a list of lists or one gigantic list depending on option chosen

    private final ArrayList<FilmListEntry> listOfFilms;

    public TotalList() {
        listOfFilms = new ArrayList<>();
    }

    /*
    Requires: an instance of FilmListEntry that is sound
    Modifies: this
    Effects: adds the entry to the list
     */
    public void addFilm(FilmListEntry entry) {
        listOfFilms.add(entry);
    }

    /*
    Requires: entry to exist within list
    Modifies: this
    Effects: removes the entry from the list
     */
    public void removeFilm(FilmListEntry entry) {
        if (listOfFilms.contains(entry)) {
            listOfFilms.remove(entry);
        } else {
            System.out.println("Entry does not exist!");
        }
    }
}
