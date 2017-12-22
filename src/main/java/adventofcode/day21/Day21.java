package adventofcode.day21;

import adventofcode.util.InputReader;

import java.util.*;

import static java.lang.String.valueOf;

public class Day21 {

    private char[][] image;
    private Map<String, String> rulesFor2 = new HashMap<>();
    private Map<String, String> mutationsFor2 = new HashMap<>();
    private Map<String, String> rulesFor3 = new HashMap<>();
    private Map<String, String> mutationsFor3 = new HashMap<>();

    int part1(String filename, int iterations) {
        init(filename);
        addMutations();

        for (int i = 0; i < iterations; i++) {
            image = transformImage();
        }
        int count = 0;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                if (image[i][j] == '#') count++;
            }
        }
        return count;
    }

    private char[][] transformImage() {
        char[][] newImage;
        if (image.length % 2 == 0) {
            int newSize = image.length / 2 * 3;
            newImage = new char[newSize][newSize];
            for (int i = 0; i < image.length; i += 2) {
                for (int j = 0; j < image.length; j += 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(image[i][j]);
                    sb.append(image[i][j + 1]);
                    sb.append("/");
                    sb.append(image[i + 1][j]);
                    sb.append(image[i + 1][j + 1]);
                    String[] split = rulesFor2.get(sb.toString()).split("/");
                    int x = i/2*3;
                    int y = j/2*3;
                    char[] chars1 = split[0].toCharArray();
                    newImage[x][y] = chars1[0];
                    newImage[x][y + 1] = chars1[1];
                    newImage[x][y + 2] = chars1[2];
                    char[] chars2 = split[1].toCharArray();
                    newImage[x + 1][y] = chars2[0];
                    newImage[x + 1][y + 1] = chars2[1];
                    newImage[x + 1][y + 2] = chars2[2];
                    char[] chars3 = split[2].toCharArray();
                    newImage[x + 2][y] = chars3[0];
                    newImage[x + 2][y + 1] = chars3[1];
                    newImage[x + 2][y + 2] = chars3[2];
                }
            }
        } else {
            int newSize = image.length / 3 * 4;
            newImage = new char[newSize][newSize];
            for (int i = 0; i < image.length; i += 3) {
                for (int j = 0; j < image.length; j += 3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(image[i][j]);
                    sb.append(image[i][j + 1]);
                    sb.append(image[i][j + 2]);
                    sb.append("/");
                    sb.append(image[i + 1][j]);
                    sb.append(image[i + 1][j + 1]);
                    sb.append(image[i + 1][j + 2]);
                    sb.append("/");
                    sb.append(image[i + 2][j]);
                    sb.append(image[i + 2][j + 1]);
                    sb.append(image[i + 2][j + 2]);
                    String[] split = rulesFor3.get(sb.toString()).split("/");
                    int x=i/3*4;
                    int y=j/3*4;
                    char[] chars1 = split[0].toCharArray();
                    newImage[x][y] = chars1[0];
                    newImage[x][y + 1] = chars1[1];
                    newImage[x][y + 2] = chars1[2];
                    newImage[x][y + 3] = chars1[3];
                    char[] chars2 = split[1].toCharArray();
                    newImage[x + 1][y] = chars2[0];
                    newImage[x + 1][y + 1] = chars2[1];
                    newImage[x + 1][y + 2] = chars2[2];
                    newImage[x + 1][y + 3] = chars2[3];
                    char[] chars3 = split[2].toCharArray();
                    newImage[x + 2][y] = chars3[0];
                    newImage[x + 2][y + 1] = chars3[1];
                    newImage[x + 2][y + 2] = chars3[2];
                    newImage[x + 2][y + 3] = chars3[3];
                    char[] chars4 = split[3].toCharArray();
                    newImage[x + 3][y] = chars4[0];
                    newImage[x + 3][y + 1] = chars4[1];
                    newImage[x + 3][y + 2] = chars4[2];
                    newImage[x + 3][y + 3] = chars4[3];
                }
            }
        }
        return newImage;
    }

    private void init(String filename) {
        image = new char[][]{{'.', '#', '.'}, {'.', '.', '#'}, {'#', '#', '#'}};
        new InputReader().getLinesAsString(filename).forEach(line -> {
            String[] split = line.split(" => ");
            if (split[0].length() == 5) {
                rulesFor2.put(split[0], split[1]);
            } else if (split[0].length() == 11) {
                rulesFor3.put(split[0], split[1]);
            } else {
                throw new IllegalStateException("Illegal capture " + split[0]);
            }
        });
    }

    private void addMutations() {
        rulesFor2.keySet().forEach(key -> {
            char[] keychar = key.toCharArray();
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[1], keychar[0],
                            '/',
                            keychar[4], keychar[3]}),
                    rulesFor2.get(key));
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[3], keychar[4],
                            '/',
                            keychar[0], keychar[1]}),
                    rulesFor2.get(key));
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[3], keychar[0],
                            '/',
                            keychar[4], keychar[1]}),
                    rulesFor2.get(key));
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[4], keychar[3],
                            '/',
                            keychar[1], keychar[0]}),
                    rulesFor2.get(key));
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[1], keychar[4],
                            '/',
                            keychar[0], keychar[3]}),
                    rulesFor2.get(key));
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[4], keychar[1],
                            '/',
                            keychar[3], keychar[0]}),
                    rulesFor2.get(key));
            mutationsFor2.put(valueOf(
                    new char[]{
                            keychar[0], keychar[3],
                            '/',
                            keychar[1], keychar[4]}),
                    rulesFor2.get(key));
        });

        rulesFor3.keySet().forEach(key -> {
            char[] keychar = key.toCharArray();
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[8], keychar[9], keychar[10],
                            '/',
                            keychar[4], keychar[5], keychar[6],
                            '/',
                            keychar[0], keychar[1], keychar[2]}),
                    rulesFor3.get(key));
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[2], keychar[1], keychar[0],
                            '/',
                            keychar[6], keychar[5], keychar[4],
                            '/',
                            keychar[10], keychar[9], keychar[8]}),
                    rulesFor3.get(key));
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[8], keychar[4], keychar[0],
                            '/',
                            keychar[9], keychar[5], keychar[1],
                            '/',
                            keychar[10], keychar[6], keychar[2]}),
                    rulesFor3.get(key));
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[10], keychar[9], keychar[8],
                            '/',
                            keychar[6], keychar[5], keychar[4],
                            '/',
                            keychar[2], keychar[1], keychar[0]}),
                    rulesFor3.get(key));
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[2], keychar[6], keychar[10],
                            '/',
                            keychar[1], keychar[5], keychar[9],
                            '/',
                            keychar[0], keychar[4], keychar[8]}),
                    rulesFor3.get(key));
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[0], keychar[4], keychar[8],
                            '/',
                            keychar[1], keychar[5], keychar[9],
                            '/',
                            keychar[2], keychar[6], keychar[10]}),
                    rulesFor3.get(key));
            mutationsFor3.put(valueOf(
                    new char[]{
                            keychar[10], keychar[6], keychar[2],
                            '/',
                            keychar[9], keychar[5], keychar[1],
                            '/',
                            keychar[8], keychar[4], keychar[0]}),
                    rulesFor3.get(key));
        });

        rulesFor2.putAll(mutationsFor2);
        rulesFor3.putAll(mutationsFor3);
    }

    private List<String> getImageParts() {
        List<String> partialImage = new ArrayList<>();
        if (image.length % 2 == 0) {
            for (int i = 0; i < image.length; i += 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(image[i][i]);
                sb.append(image[i][i + 1]);
                sb.append('/');
                sb.append(image[i + 1][i]);
                sb.append(image[i + 1][i + 1]);
                partialImage.add(sb.toString());
            }
        } else if (image.length % 3 == 0) {
            for (int i = 0; i < image.length; i += 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(image[i][i]);
                sb.append(image[i][i + 1]);
                sb.append(image[i][i + 2]);
                sb.append('/');
                sb.append(image[i + 1][i]);
                sb.append(image[i + 1][i + 1]);
                sb.append(image[i + 1][i + 2]);
                sb.append('/');
                sb.append(image[i + 2][i]);
                sb.append(image[i + 2][i + 1]);
                sb.append(image[i + 2][i + 2]);
                partialImage.add(sb.toString());
            }
        } else {
            throw new IllegalStateException("unknonw image size");
        }
        return partialImage;
    }

    int part2(String filename, int iterations) {
        return part1(filename, iterations);
    }
}
