package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmInfo;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaRepositiryTest {

    AfishaManager manager;
    AfishaRepository repository;
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
    void returnsAllFilms() {
        repository = new AfishaRepository();
        repository.save(film0);
        repository.save(film1);
        repository.save(film2);
        FilmInfo[] expected = new FilmInfo[]{film0, film1, film2};
        FilmInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removesAllFilms() {
        repository = new AfishaRepository();
        repository.save(film0);
        repository.save(film1);
        repository.save(film2);
        repository.removeAll();
        FilmInfo[] expected = new FilmInfo[0];
        FilmInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void actionsById() {
        repository = new AfishaRepository();
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.removeById(2);
        FilmInfo expected = null;
        FilmInfo actual = repository.findById(2);
        assertEquals(expected, actual);
    }

    @Test
    void findById() {
        repository = new AfishaRepository();
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        FilmInfo expected = film2;
        FilmInfo actual = repository.findById(2);
        assertEquals(expected, actual);
    }
}
