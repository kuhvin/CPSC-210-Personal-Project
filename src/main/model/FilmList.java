package model;

import model.events.Event;
import model.events.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.*;

//Creates lists of films that have already been watched, sortable by the details in FilmListEntry
//When a WatchLaterList film has been watched, details can be transferred
public class FilmList implements Writable {
    private int size = 0;

    public final ArrayList<FilmListEntry> filmList;

    private Event event;

    public FilmList() {
        EventLog.getInstance();
        filmList = new ArrayList<>();
    }


    /*
    Requires: an instance of FilmListEntry that is sound, and not within the list
    Modifies: this
    Effects: adds the entry to the list
     */
    public String addEntry(FilmListEntry entry) {
        if (filmList.contains(entry)) {
            EventLog.getInstance().logEvent(new Event("Attempt to add duplicate entry refused"));
            return ("This entry already exists!");
        } else {
            filmList.add(entry);
            size += 1;
            EventLog.getInstance().logEvent(new Event("Entry of name " + entry.getName() + " added"));
            return ("Entry added!");
        }
    }

    /*
    Requires: entry to exist within list
    Modifies: this
    Effects: removes the entry from the list
     */
    public String removeEntry(FilmListEntry entry) {
        if (filmList.contains(entry)) {
            filmList.remove(entry);
            size -= 1;
            EventLog.getInstance().logEvent(new Event("Entry of name " + entry.getName() + " removed"));
            return ("Entry removed!");
        }
        return ("Entry does not exist!");
    }

    /*
    Requires: film list initialized
    Effects: displays the names of the films within
     */
    public String getEntries() {    //delimiter and joiner inspired from stackoverflow
        String delimiter = ", ";
        StringJoiner joiner = new StringJoiner(delimiter);
        filmList.forEach(entry -> joiner.add(entry.getName()));
        EventLog.getInstance().logEvent(new Event("Viewed entry list"));
        return (joiner.toString());
    }

    @Override                           //from JSONSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("filmList", entriesToJson());
        return json;
    }

    // EFFECTS: returns things in this filmList as a JSON array         //from JSONSerializationDemo
    private JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (FilmListEntry f : filmList) {
            jsonArray.put(f.toJson());
        }

        return jsonArray;
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
            EventLog.getInstance().logEvent(new Event("Viewed details of entry with name " + entry.getName()));
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


    // EFFECTS: returns an unmodifiable list of thingies in this film list //from JSONSerializationDemo
    public List<FilmListEntry> getEntryList() {
        return Collections.unmodifiableList(filmList);
    }

    public void exitLog(EventLog el) {
        ArrayList<String> e = new ArrayList<>();
        for (Event next: el) {
            e.add(next.toString());
        }
        System.out.println(e.toString());
    }
}
