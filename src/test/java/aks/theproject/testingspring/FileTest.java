package aks.theproject.testingspring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class FileTest {

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getZones() {
        var zones = ZoneId.getAvailableZoneIds();
        zones.forEach(System.out::println);
    }

}