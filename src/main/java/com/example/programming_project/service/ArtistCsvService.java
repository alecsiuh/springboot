package com.example.programming_project.service;

import com.example.programming_project.domain.Artist;
import com.example.programming_project.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ArtistCsvService {
    private static final Logger logger = LoggerFactory.getLogger(ArtistCsvService.class);
    private final ArtistRepository artistRepository;

    @Async
    public void processCsv(InputStream csvStream) {
        var scanner = new Scanner(csvStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            logger.info(line);
            String[] csvRow = line.split(",");
            String name = csvRow[0];
            String gender = csvRow[1];
            int debutYear = Integer.parseInt(csvRow[2]);
            Artist newArtist = new Artist(name, gender, debutYear);
            try {
                artistRepository.save(newArtist);
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

