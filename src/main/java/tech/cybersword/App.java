package tech.cybersword;

import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(
                    "Usage: java -jar tech.cybersword.audio-*.jar <test name> <target path> <source path> <file endings> <setExif true|false> <use glitch true|false>");
            System.exit(1);
        }

        if (logger.isInfoEnabled()) {
            logger.info("Starting application...");
        }

        String testName = args[0] + "_" + getCurrentDate();
        String targetPath = args[1];
        String sourcePath = args[2];
        String fileEndings = args[3];
        Boolean setExif = Boolean.parseBoolean(args[4]);
        Boolean useGlitch = Boolean.parseBoolean(args[5]);

        Audio2ByteArrayReader reader = new Audio2ByteArrayReader();
        // Load templates
        byte[] aiff = reader.getAudioAsByteArray("generate_media_files/cybersword.tech.aiff");
        byte[] mp3 = reader.getAudioAsByteArray("generate_media_files/cybersword.tech.mp3");
        byte[] ogg = reader.getAudioAsByteArray("generate_media_files/cybersword.tech.ogg");
        byte[] wav = reader.getAudioAsByteArray("generate_media_files/cybersword.tech.wav");

        DirectoryReader payloadReader = new DirectoryReader(sourcePath, fileEndings);
        Map<String, String> payloads = payloadReader.readTxtFilesToHashMap();

        Audio2ByteArrayWriter writer = new Audio2ByteArrayWriter();

        if (payloads != null && payloads.size() > 0) {
            Set<String> keys = payloads.keySet();
            for (String key : keys) {
                if (null != key && key.length() > 0) {

                    String toAdd = payloads.get(key);

                    if (logger.isInfoEnabled()) {
                        logger.info(String.format("%s -> %s", key, toAdd));
                    }

                    writer.writeAudioAsByteArray(targetPath + "/" + testName + "_aiff_" + key + ".aiff", aiff,
                            toAdd.getBytes(), useGlitch, "aiff");
                    writer.writeAudioAsByteArray(targetPath + "/" + testName + "_mp3_" + key + ".mp3", mp3,
                            toAdd.getBytes(),
                            useGlitch, "mp3");
                    writer.writeAudioAsByteArray(targetPath + "/" + testName + "_ogg_" + key + ".ogg", ogg,
                            toAdd.getBytes(),
                            useGlitch, "ogg");
                    writer.writeAudioAsByteArray(targetPath + "/" + testName + "_wav_" + key + ".wav", wav,
                            toAdd.getBytes(),
                            useGlitch, "wav");
                }
            }
        }
    }

    public static String getCurrentDate() {
        return new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
}
