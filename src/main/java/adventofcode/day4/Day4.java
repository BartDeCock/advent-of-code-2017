package adventofcode.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

class Day4 {

    int calculatePart1(String filename) {
        int[] count = {0};
        getPassPhrazes(filename).forEach(line -> {
            if (!hasDoubles(line)) {
                count[0]++;
            }
        });
        return count[0];
    }

    int calculatePart2(String filename) {
        int[] count = {0};
        getPassPhrazes(filename).forEach(line -> {
            if (!hasAnagram(line)) {
                count[0]++;
            }
        });

        return count[0];
    }


    private List<List<String>> getPassPhrazes(String filename) {
        List<List<String>> passPhrazes = new ArrayList<>();
        try {
            URL resource = this.getClass().getClassLoader().getResource(filename);
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
            reader.lines()
                    .map(line -> Pattern.compile(" ").splitAsStream(line).collect(toList()))
                    .forEach(passPhrazes::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passPhrazes;
    }

    private boolean hasDoubles(List<String> words) {
        Set<String> singels = new HashSet<>();
        final boolean[] hasDouble = {false};
        words.forEach(word -> {
            if (!singels.add(word)) {
                hasDouble[0] = true;
            }
        });
        return hasDouble[0];
    }

    private boolean hasAnagram(List<String> words) {
        Set<String> singels = new HashSet<>();
        final boolean[] isAnagram = {false};
        words.forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            if (!singels.add(String.valueOf(chars))) {
                isAnagram[0] = true;
            }
        });
        return isAnagram[0];
    }

    private static boolean compare(String a, String b){
        char[] aArr = a.toLowerCase().toCharArray(), bArr = b.toLowerCase().toCharArray();
        if (aArr.length != bArr.length)
            return false;
        int[] counts = new int[26]; // An array to hold the number of occurrences of each character
        for (int i = 0; i < aArr.length; i++){
            counts[aArr[i]-97]++;  // Increment the count of the character at i
            counts[bArr[i]-97]--;  // Decrement the count of the character at i
        }
        // If the strings are anagrams, the counts array will be full of zeros
        for (int i = 0; i<26; i++)
            if (counts[i] != 0)
                return false;
        return true;
    }


}
