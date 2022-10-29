package persistence;

import model.FilmList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.FilmListEntry;
import org.json.*;

// Represents a reader that reads filmList from JSON data stored in file, largely inspired from JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads film list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public FilmList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFilmList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses filmList from JSON object and returns it
    private FilmList parseFilmList(JSONObject jsonObject) {
        FilmList fl = new FilmList();
        addEntries(fl, jsonObject);
        return fl;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to film list
    private void addEntries(FilmList fl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("filmList");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addEntry(fl, nextEntry);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to film list
    private void addEntry(FilmList fl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String tom = jsonObject.getString("type of media");
        String genre = jsonObject.getString("genre");
        int runtime = jsonObject.getInt("runtime");
        int year = jsonObject.getInt("year");
        double rating = jsonObject.getDouble("rating");

        FilmListEntry entry = new FilmListEntry(name, tom, genre, runtime, year, rating);
        fl.addEntry(entry);
    }
}
