package adventofcode.day10;

import adventofcode.util.InputReader;
import com.google.common.collect.Lists;
import com.sun.jmx.snmp.internal.SnmpTools;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.toHexString;
import static java.util.stream.Collectors.toList;

public class Day10 {

    int calculatePart1(String filename, List<Integer> given) {
        List<Integer> lengths = Arrays.stream(new InputReader().getLinesAsString(filename).get(0).split(",")).map(Integer::valueOf).collect(toList());
        final int[] currentPos = {0};
        final int[] skip = {0};

        lengths.forEach(l -> {
            executeConversion(given, given.size(), currentPos, skip, l);
        });

        return given.get(0)*given.get(1);
    }

    private void executeConversion(List<Integer> input, int size, int[] currentPos, int[] skip, Integer l) {
        List<Integer> copy = new ArrayList<>(input);
        for (int i = 0; i < l; i++) {
            int indexToSet = currentPos[0] + i >= size? currentPos[0] + i - size : currentPos[0] + i;
            int indexToGet = currentPos[0] + l -1 -i >= size ? currentPos[0] + l -1 -i -size:currentPos[0]+l-1-i;
            input.set(indexToSet, copy.get(indexToGet));
        }
        currentPos[0] = currentPos[0] + l + skip[0];
        while (currentPos[0] >=size) {
            currentPos[0] = currentPos[0] - size;
        }
        skip[0]++;
    }

    String calculatePart2(String filename, List<Integer> given) {
        List<Integer> lengths = new ArrayList<>();
        char[] chars = new InputReader().getLinesAsString(filename).get(0).toCharArray();
        for (int i = 0; i< chars.length; i++) {
            lengths.add((int) chars[i]);
        }
        lengths.addAll(Lists.newArrayList(17, 31, 73, 47, 23));
        System.out.println("lengths: " + lengths);
        //
        final int[] currentPos = {0};
        final int[] skip = {0};

        for (int c=0;c<64;c++) {
            System.out.println("Starting round " + c + " - currentPos=" + currentPos[0]);
            lengths.forEach(l -> {
                executeConversion(given, given.size(), currentPos, skip, l);
            });
        }

        List<Integer> denseHash = new ArrayList<>();
        for (int i=0;i<16;i++) {
            List<Integer> sub = given.subList(i*16, i*16+16);
            denseHash.add(sub.stream().reduce((i1,i2)->i1 ^ i2).get());
        }

        StringBuilder sb = new StringBuilder();
        denseHash.stream().forEach(integer -> {
            String str = toHexString(integer);
            if (str.length()==1) str = "0"+str;
            sb.append(str);
        });
        return sb.toString();
    }


}
