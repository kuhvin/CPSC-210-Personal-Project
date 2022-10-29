package persistence;

import model.FilmList;
import model.FilmListEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {                         //inspired from JSONSerializationDemo
    protected void checkEntry(String name, String tom, String genre,
                               int runtime, int year, double rating, FilmListEntry entry) {
        assertEquals(name, entry.getName());
        assertEquals(tom, entry.getType());
        assertEquals(genre, entry.getGenre());
        assertEquals(runtime, entry.getRuntime());
        assertEquals(year, entry.getYear());
        assertEquals(rating, entry.getRating());
    }
}
