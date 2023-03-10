package model;

import model.FilmList;
import model.FilmListEntry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//tests for FilmList class
public class FilmListTest {
    FilmList list1 = new FilmList();
    FilmList list2 = new FilmList();

    FilmListEntry movie1 = new FilmListEntry("Dunkirk", "Film", "War", 106,
            2017, 7.8);
    FilmListEntry movie2 = new FilmListEntry("La La Land", "Film", "Musical", 128,
            2016, 8.0);
    FilmListEntry show1 = new FilmListEntry("Arcane", "Animation TV", "Drama", 396,
            2021, 9.6);

    @Test
    public void addEntryTest() {
        list1.addEntry(movie1);

        assertEquals("Dunkirk", list1.getEntries());
    }

    @Test
    public void addMultipleEntriesTest() {
        list1.addEntry(movie1);
        list1.addEntry(movie2);

        assertEquals("Dunkirk, La La Land", list1.getEntries());
        assertEquals("Entry added!", list1.addEntry(show1));
        assertEquals("Dunkirk, La La Land, Arcane", list1.getEntries());
    }

    @Test
    public void addDuplicateEntryTest() {
        list1.addEntry(movie1);
        list1.addEntry(movie1);

        assertEquals("This entry already exists!", list1.addEntry(movie1));
        assertEquals("Dunkirk", list1.getEntries());
    }

    @Test
    public void removeEntryTest() {
        list2.addEntry(movie1);
        list2.addEntry(movie2);
        list2.addEntry(show1);

        assertEquals("Dunkirk, La La Land, Arcane", list2.getEntries());

        list2.removeEntry(movie1);

        assertEquals("La La Land, Arcane", list2.getEntries());

        list2.removeEntry(show1);
        list2.removeEntry(show1);

        assertEquals("La La Land", list2.getEntries());
        assertEquals("Entry does not exist!", list2.removeEntry(show1));
        assertEquals("Entry removed!", list2.removeEntry(movie2));
    }

    @Test
    public void viewEntryTest() {
        list1.addEntry(show1);

        assertEquals("Arcane, Animation TV, Drama. Runtime: 396 minutes, made in 2021. " +
                "Rated at 9.6 out of 10.", list1.viewEntry(show1));
        assertEquals("Entry does not exist!", list1.viewEntry(movie1));
    }

    @Test
    public void getEntryTest() {
        list1.addEntry(movie2);
        list1.addEntry(movie1);

        assertEquals(movie2, list1.getEntry(0));
        assertEquals(movie1, list1.getEntry(1));
    }

    @Test
    public void getSizeTest() {
        list1.addEntry(show1);
        list1.addEntry(show1);
        list1.addEntry(movie1);

        assertEquals(2, list1.getSize());
    }
}
