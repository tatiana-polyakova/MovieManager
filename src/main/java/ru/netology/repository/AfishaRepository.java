package ru.netology.repository;

import ru.netology.domain.FilmInfo;

public class AfishaRepository {

    private FilmInfo[] infos = new FilmInfo[0];

    public void save(FilmInfo info) {
        int length = infos.length + 1;
        FilmInfo[] tmp = new FilmInfo[length];

        for (int i = 0; i < infos.length; i++) {
            tmp[i] = infos[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = info;
        infos = tmp;
    }

    public FilmInfo[] findAll() {
        return infos;
    }

    public void removeById(int id) {
        int length = infos.length - 1;
        FilmInfo[] tmp = new FilmInfo[length];

        int index = 0;
        for (FilmInfo info : infos) {
            if (info.getFilmId() != id) {
                tmp[index] = info;
                index++;
            }
        }
        infos = tmp;
    }

    public void removeAll() {
        infos = new FilmInfo[0];
    }

    public FilmInfo findById(int id) {
        for (FilmInfo info : infos) {
            if (info.getFilmId() == id) {
                return info;
            }
        }
        return null;
    }
}