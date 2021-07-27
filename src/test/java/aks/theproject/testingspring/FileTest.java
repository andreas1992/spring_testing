package aks.theproject.testingspring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.Test;

// https://www.marcobehler.com/guides/java-files
public class FileTest {

    private Path pathTestTxt = Path.of("src\\test\\java\\aks\\theproject\\testingspring\\resources\\test.txt");
    private Path testPath = Path.of("src\\test\\java\\aks\\theproject\\testingspring\\resources");

    @Test
    void testReadFile() {
        var pathStr = "src\\test\\java\\aks\\theproject\\testingspring\\resources\\test.txt";
        var path = Path.of(pathStr);
        var pathAsAgruments = Path.of("src", "test", "java", "aks", "theproject", "testingspring", "resources", "test.txt");
        
        System.out.println(Files.exists(path));
        System.out.println(pathAsAgruments + " Exists? " + Files.exists(pathAsAgruments));

        try {
            var timeModified = Files.getLastModifiedTime(path);

            System.out.println(timeModified);
            System.out.println(timeModified.toInstant());
            System.out.println(timeModified.toInstant().atZone(ZoneId.systemDefault()));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("CET")));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).toLocalDateTime());
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.RFC_1123_DATE_TIME));
            System.out.println(timeModified.toInstant().atZone(ZoneId.of("Europe/Oslo")).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.MEDIUM)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getZones() {
        var zones = ZoneId.getAvailableZoneIds();
        zones.forEach(System.out::println);
    }

    @Test
    void createFile() {
        var pathParent = pathTestTxt.getParent();
        System.out.println(pathParent);

        System.out.println(Files.exists(pathTestTxt.getParent().resolve("TestFile.txt")));

        try {
            var newFile = Files.createFile(pathParent.resolve("TestFile.txt"));
            System.out.println(newFile);
            Thread.sleep(2000);
            var deleted = Files.deleteIfExists(newFile);
            System.out.println("Deleted? " + deleted);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void writeToFile() throws IOException {
        var newFile = Files.createFile(pathTestTxt.getParent().resolve("Testing.txt"));

        Files.writeString(newFile, "Sømething written here");

        Files.deleteIfExists(newFile);
    }

    @Test
    void readStringFile() throws IOException {
        var testString = Files.readString(testPath.resolve("test.txt"));
        System.out.println(testString);
    }

}