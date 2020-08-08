
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.FilmInfo;
import ru.netology.manager.FilmsManager;

import static org.junit.Assert.assertEquals;

public class FilмsTest {

    FilmsManager manager;
    FilmInfo element = new FilmInfo();

    @BeforeEach
    void BeforeEach() {
        manager = null;
    }

    void addAmountOfFilms(FilmsManager manager, int amount) {
        for (int i = 0; i < amount; i++) {
            manager.add(element);
        }
    }

    @org.junit.jupiter.api.Test
    void ifAddFirsFilmAddOneFilm() {
        manager = new FilmsManager();
        addAmountOfFilms(manager, 2);
        int expected = 2;
        int actual = manager.getArrayLenght();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void ifManagerHasTenFilmsReturnsLastTenFilms() {
        manager = new FilmsManager();
        addAmountOfFilms(manager, 10);
        FilmInfo[] myLastFilms = manager.returnLastFilms();
        int expected = 10;
        int actual = myLastFilms.length;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void ifManagerHasTenFilmsAndAskedForSevenFilmsReturnsLastSevenFilms() {
        manager = new FilmsManager(7);
        addAmountOfFilms(manager, 10);
        FilmInfo[] myLastFilms = manager.returnLastFilms();
        int expected = 7;
        int actual = myLastFilms.length;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void ifManagerHasTenFilmsAndAskedForMinusOneFilmsReturnsLastTenFilms() {
        manager = new FilmsManager(-1);
        addAmountOfFilms(manager, 10);
        FilmInfo[] myLastFilms = manager.returnLastFilms();
        int expected = 10;
        int actual = myLastFilms.length;
        assertEquals(expected, actual);
    }
}