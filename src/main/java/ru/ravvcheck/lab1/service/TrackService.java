package ru.ravvcheck.lab1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ravvcheck.lab1.dto.TrackDto;
import ru.ravvcheck.lab1.entity.Track;
import ru.ravvcheck.lab1.repository.TrackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    @Transactional
    public void create(TrackDto trackDto) {
        var newTrack = Track.builder()
                .name(trackDto.getName())
                .author(trackDto.getAuthor())
                .numberOfPlays(trackDto.getNumberOfPlays())
                .build();
        trackRepository.save(newTrack);
    }

    @Transactional
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
