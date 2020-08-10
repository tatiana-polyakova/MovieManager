package ru.netology.domain;

public class FilmInfo {
    private int FilmId;
    private String FilmName;

    public FilmInfo() {
    }

    public FilmInfo(int filmId, String filmName) {
        FilmId = filmId;
        FilmName = filmName;
    }
}