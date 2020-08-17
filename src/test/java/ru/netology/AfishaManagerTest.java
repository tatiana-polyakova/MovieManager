package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmInfo;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager;
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

    @BeforeEach
    public void setUp() {
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
    }

    @AfterEach
    public void tearDown() {
        manager.removeAll();
    }

    @Test
    void ifAddFilmFilmAdded() {
        FilmInfo[] returned = new FilmInfo[]{film1, film2, film3, film4};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(film4);
        manager.add(film4);
        FilmInfo[] expected = new FilmInfo[]{film1, film2, film3, film4};
        FilmInfo[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void ifManagerHasTenFilmsReturnsLastTenFilms() {
        FilmInfo[] returned = new FilmInfo[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(any());
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        FilmInfo[] expected = new FilmInfo[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        FilmInfo[] actual = manager.returnLastFilms();
        assertArrayEquals(expected, actual);
    }
}