package ru.netology.domain;

public class FilmInfo {
    private int filmId;
    private String filmName;

    public FilmInfo() {
    }

    public FilmInfo(int filmId, String filmName) {
        this.filmId = filmId;
        this.filmName = filmName;
    }
}