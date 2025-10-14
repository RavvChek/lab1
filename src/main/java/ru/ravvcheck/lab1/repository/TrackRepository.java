package ru.ravvcheck.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravvcheck.lab1.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    Track findByName(String name);
}
