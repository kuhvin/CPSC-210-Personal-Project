package model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner; //from stackoverflow

//Creates lists of films that have already been watched, sortable by the details in FilmListEntry
//When a WatchLaterList film has been watched, details can be transferred
public class FilmList {
    private int size = 0;

    public final ArrayList<FilmListEntry> filmList;

    public FilmList() {
        filmList = new ArrayList<>();
    }

    /*
    Requires: an instance of FilmListEntry that is sound, and not within the list
    Modifies: this
    Effects: adds the entry to the list
     */
    public void addEntry(FilmListEntry entry) {
        if (filmList.contains(entry)) {
            System.out.println("This entry already exists!");
        } else {
            filmList.add(entry);
            size += 1;
        }
    }

    /*
    Requires: entry to exist within list
    Modifies: this
    Effects: removes the entry from the list
     */
    public void removeEntry(FilmListEntry entry) {
        if (filmList.contains(entry)) {
            filmList.remove(entry);
            size -= 1;
        } else {
            System.out.println("Entry does not exist!");
        }
    }

    /*
    Requires: film list initialized
    Effects: displays the names of the films within
     */
    public String getEntries() {    //delimiter and joiner inspired from stackoverflow
        String delimiter = ", ";

        StringJoiner joiner = new StringJoiner(delimiter);
        filmList.forEach(entry -> joiner.add(entry.getName()));
        return (joiner.toString());
    }

    /*
    Requires: entry exists in film list
    Effects: Returns the entry in question
     */
    public FilmListEntry getEntry(int i) {
        return filmList.get(i);
    }

    /*
    Requires: entry exists in list
    Effects: displays the entry and all criteria
     */
    public String viewEntry(FilmListEntry entry) {
        if (filmList.contains(entry)) {
            return entry.getAll();
        } else {
            return ("Entry does not exist!");
        }
    }

    /*
    Effects: displays size
     */
    public int getSize() {
        return size;
    }
}
