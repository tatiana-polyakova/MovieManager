package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.FilmInfo;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int variableQuantity = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(FilmInfo info) {
        repository.save(info);
    }

    public FilmInfo[] findAll() {
        return repository.findAll();
    }

    public FilmInfo[] returnLastFilms() {
        FilmInfo[] infos = findAll();
        int realLastFilmsCount = Math.min(infos.length, variableQuantity);

        FilmInfo[] lastFilms = new FilmInfo[realLastFilmsCount];
        int takenFilmsCount = 0;

        for (int i = infos.length - 1; takenFilmsCount < realLastFilmsCount; i--) {
            FilmInfo currentElement = infos[i];
            lastFilms[takenFilmsCount] = currentElement;
            takenFilmsCount = takenFilmsCount + 1;
        }
        return lastFilms;
    }

    public void removeAll() {
        repository.removeAll();
    }
}