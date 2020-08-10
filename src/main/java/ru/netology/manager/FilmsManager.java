package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.FilmInfo;

@NoArgsConstructor
public class FilmsManager {
    private FilmInfo[] infos = new FilmInfo[0];
    private int variableQuantity = 10;

    public FilmsManager(int variableQuantity) {
        if (variableQuantity <= 0) {
            return;
        }
        this.variableQuantity = variableQuantity;
    }

    public void add(FilmInfo info) {
        int length = infos.length + 1;
        FilmInfo[] tmp = new FilmInfo[length];

        for (int i = 0; i < infos.length; i++) {
            tmp[i] = infos[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = info;
        infos = tmp;
    }

    public FilmInfo[] getAll(){
        return infos;
    }

    public FilmInfo[] returnLastFilms() {
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
}