package ru.ravvcheck.lab1.dto;

import lombok.Data;

@Data
public class TrackDto {
    private String name;
    private String author;
    private Integer numberOfPlays;
}
