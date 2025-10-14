package ru.ravvcheck.lab1.service;

import jakarta.persistence.EntityNotFoundException;
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
    private TrackRepository trackRepository;

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
    public Track save(Track track) {
        return trackRepository.save(track);
    }

    @Transactional
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Transactional
    public Track getTrackByName(String name) {
        var track = trackRepository.findByName(name);
        if (track == null) {
            throw new EntityNotFoundException("Трек не найден!");
        }
        return track;
    }
}
