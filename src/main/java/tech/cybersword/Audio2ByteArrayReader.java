package tech.cybersword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Audio2ByteArrayReader {

    private static Logger logger = LogManager.getLogger(Audio2ByteArrayReader.class);

    public byte[] getAudioAsByteArray(String audioFilePath) {
        if (audioFilePath == null) {
            throw new IllegalArgumentException("audioFilePath darf nicht null sein");
        }
        try {
            Path path = Paths.get(audioFilePath);
            byte[] mp3Bytes = Files.readAllBytes(path);

            if (logger.isInfoEnabled()) {
                logger.info("Datei erfolgreich geladen, Größe: " + mp3Bytes.length + " Bytes");

            }

            return mp3Bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}