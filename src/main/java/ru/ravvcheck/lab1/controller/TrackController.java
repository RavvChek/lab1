package ru.ravvcheck.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ravvcheck.lab1.dto.TrackDto;
import ru.ravvcheck.lab1.entity.Track;
import ru.ravvcheck.lab1.service.TrackService;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping()
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @PostMapping()
    public void create(@RequestBody TrackDto trackDto) {
        trackService.create(trackDto);
    }
}
