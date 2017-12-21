package adventofcode.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public List<String> getLinesAsString(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            URL resource = this.getClass().getClassLoader().getResource(filename);
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
            reader.lines().forEach(lines::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<Integer> getLinesAsInteger(String filename) {
        List<Integer> lines = new ArrayList<>();
        try {
            URL resource = this.getClass().getClassLoader().getResource(filename);
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
            reader.lines().map(Integer::valueOf).forEach(lines::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
