package persistence;

import model.FilmListEntry;
import model.FilmList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {                 //tests inspired from JSONSerializationDemo

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            FilmList fl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFilmList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFilmList.json");
        try {
            FilmList fl = reader.read();
            assertEquals(0, fl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralFilmList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFilmList.json");
        try {
            FilmList fl = reader.read();
            List<FilmListEntry> filmList = fl.getEntryList();
            assertEquals(2, filmList.size());
            checkEntry("Saving Private Ryan", "Film", "War", 20,
                    2017, 7.8, filmList.get(0));
            checkEntry("La La Land", "TV", "Musical", 128,
                    2023, 8.0, filmList.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
            //
        }
    }
}