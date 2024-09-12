package tech.cybersword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Audio2ByteArrayWriter {
    public static Logger logger = LogManager.getLogger(Audio2ByteArrayWriter.class);

    public void writeAudioAsByteArray(String audioFilePathTarget, byte[] audioBytes, byte[] payload,
            boolean useGlitch, String fileType) {
        if (audioFilePathTarget == null) {
            throw new IllegalArgumentException("audioFilePath darf nicht null sein");
        }
        if (audioBytes == null) {
            throw new IllegalArgumentException("audioBytes darf nicht null sein");
        }
        try {
            byte[] a = new byte[audioBytes.length + payload.length + 10];
            switch (fileType) {
                case "aiff":
                    addPayloadToAudio(audioBytes, payload, a);
                    saveAudioFile(audioFilePathTarget, a);
                    break;
                case "mp3":
                    addPayloadToAudio(audioBytes, payload, a);
                    saveAudioFile(audioFilePathTarget, a);
                    break;
                case "ogg":
                    addPayloadToAudio(audioBytes, payload, a);
                    saveAudioFile(audioFilePathTarget, a);
                    break;
                case "wav":
                    addPayloadToAudio(audioBytes, payload, a);
                    saveAudioFile(audioFilePathTarget, a);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveAudioFile(String audioFilePathTarget, byte[] audioBytes) {
        try {
            Files.write(Paths.get(audioFilePathTarget), audioBytes);
            if (logger.isInfoEnabled()) {
                logger.info("Datei erfolgreich geschrieben, Größe: " + audioBytes.length + " Bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addPayloadToAudio(byte[] audioBytes, byte[] payload, byte[] a) {
        int c = 0;
        for (int i = (a.length - 1) / 2; i < a.length; i++) {
            if (c >= payload.length) {
                // c = 0;
            } else {
                a[i] = payload[c];
                c++;
            }
        }
    }
}