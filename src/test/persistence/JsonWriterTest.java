package persistence;

import model.FilmListEntry;
import model.FilmList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {                 //inspired from JSONSerializationDemo

    @Test
    void testWriterInvalidFile() {
        try {
            FilmList fl = new FilmList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyFilmList() {
        try {
            FilmList filmList = new FilmList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(filmList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            filmList = reader.read();
            assertEquals(0, filmList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralFilmList() {
        try {
            FilmList filmList = new FilmList();
            filmList.addEntry(new FilmListEntry("Saving Private Ryan", "Film", "War",
                    20,2017, 7.8));
            filmList.addEntry(new FilmListEntry("La La Land", "TV", "Musical", 128,
                    2023, 8.0));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(filmList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            filmList = reader.read();
            List<FilmListEntry> fl = filmList.getEntryList();
            assertEquals(2, fl.size());
            checkEntry("Saving Private Ryan", "Film", "War", 20,
                    2017, 7.8, fl.get(0));
            checkEntry("La La Land", "TV", "Musical", 128,
                    2023, 8.0, fl.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}