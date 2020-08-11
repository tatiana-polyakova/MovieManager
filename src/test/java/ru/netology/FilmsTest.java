package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmInfo;
import ru.netology.manager.FilmsManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmsTest {

    FilmsManager manager;
    FilmInfo film0 = new FilmInfo(); // for default constructor testing coverage
    FilmInfo film1 = new FilmInfo(1, "Фильм 1");
    FilmInfo film2 = new FilmInfo(2, "Фильм 2");
    FilmInfo film3 = new FilmInfo(3, "Фильм 3");
    FilmInfo film4 = new FilmInfo(4, "Фильм 4");
    FilmInfo film5 = new FilmInfo(5, "Фильм 5");
    FilmInfo film6 = new FilmInfo(6, "Фильм 6");
    FilmInfo film7 = new FilmInfo(7, "Фильм 7");
    FilmInfo film8 = new FilmInfo(8, "Фильм 7");
    FilmInfo film9 = new FilmInfo(9, "Фильм 9");
    FilmInfo film10 = new FilmInfo(10, "Фильм 10");

    @Test
    void ifAddFilmFilmAdded() {
        manager = new FilmsManager();
        manager.add(film0);
        manager.add(film1);
        FilmInfo[] expected = new FilmInfo[]{film0, film1};
        FilmInfo[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void ifManagerHasTenFilmsReturnsLastTenFilms() {
        manager = new FilmsManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        FilmInfo[] expected = new FilmInfo[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmInfo[] actual = manager.returnLastFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void ifManagerHasTenFilmsAndAskedForSevenFilmsReturnsLastSevenFilms() {
        manager = new FilmsManager(7);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        FilmInfo[] expected = new FilmInfo[]{film7, film6, film5, film4, film3, film2, film1};
        FilmInfo[] actual = manager.returnLastFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void ifManagerHasTenFilmsAndAskedForMinusOneFilmsReturnsLastTenFilms() {
        manager = new FilmsManager(-1);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        FilmInfo[] expected = new FilmInfo[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        FilmInfo[] actual = manager.returnLastFilms();
        assertArrayEquals(expected, actual);
    }
}