package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Test for FilmEntry class
public class FilmListEntryTest {
    FilmListEntry movie1 = new FilmListEntry("Saving Private Ryan", "Film", "War", 20,
            2017, 7.8);
    FilmListEntry movie2 = new FilmListEntry("La La Land", "TV", "Musical", 128,
            2023, 8.0);
    FilmListEntry show1 = new FilmListEntry("Arcane", "Animation TV", "Comedy", 396,
            2021, 3.0);


    @Test
    void testConstructor() {
        assertEquals("Arcane", show1.getName());
        assertEquals("Animation TV", show1.getType());
        assertEquals("Comedy", show1.getGenre());
        assertEquals(396, show1.getRuntime());
        assertEquals(2021, show1.getYear());
        assertEquals(3.0, show1.getRating());
    }


    @Test
    void filmListEntryTest() {
        assertEquals("Saving Private Ryan, Film, War. Runtime: 20 minutes, made in 2017. " +
                        "Rated at 7.8 out of 10.", movie1.getAll());
        assertEquals("La La Land, TV, Musical. Runtime: 128 minutes, made in 2023. Rated at 8.0 out of 10.",
                movie2.getAll());
        assertEquals("Arcane, Animation TV, Comedy. Runtime: 396 minutes, made in 2021. Rated at 3.0 out of 10.",
                show1.getAll());
    }

    @Test
    void updateNameTest() {
        movie1.updateName("");

        assertEquals("", movie1.getName());

        movie1.updateName("Dunkirk");

        assertEquals("Dunkirk", movie1.getName());
    }

    @Test
    void updateTypeTest(){
        movie2.updateType("Film");

        assertEquals("Film", movie2.getType());
    }

    @Test
    void updateGenreTest(){
        show1.updateGenre("Drama");

        assertEquals("Drama", show1.getGenre());
    }

    @Test
    void updateRuntimeTest(){
        movie1.updateLength(106);

        assertEquals(106, movie1.getRuntime());

        movie1.updateLength(-200);

        assertEquals(106, movie1.getRuntime());
    }

    @Test
    void updateYearTest(){
        movie2.updateYear(2016);

        assertEquals(2016, movie2.getYear());

        movie2.updateYear(-2016);

        assertEquals(2016, movie2.getYear());
    }

    @Test
    void updateRatingTest() {
        show1.updateRating(9.8);

        assertEquals(9.8, show1.getRating());

        show1.updateRating(-0.1);

        assertEquals(9.8, show1.getRating());
    }
}