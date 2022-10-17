package model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Test for FilmEntry class
class FilmListEntryTest {
    FilmListEntry movie1 = new FilmListEntry("Saving Private Ryan", "Film", "War", 20,
            2017, 7.8);
    FilmListEntry movie2 = new FilmListEntry("La La Land", "TV", "Musical", 128,
            2023, 8.0);
    FilmListEntry show1 = new FilmListEntry("Arcane", "Animation TV", "Comedy", 396,
            2021, 3.0);

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

        assertEquals(106, movie1.getLength());
    }

    @Test
    void updateYearTest(){
        movie2.updateYear(2016);

        assertEquals(2016, movie2.getYear());
    }

    @Test
    void updateRatingTest() {
        show1.updateRating(9.8);

        assertEquals(9.8, show1.getRating());
    }
}