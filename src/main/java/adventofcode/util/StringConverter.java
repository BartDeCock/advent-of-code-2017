package adventofcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConverter {

    public List<Integer> convert(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        List<Integer> result = new ArrayList<>();
        while (m.find()) {
            result.add(Integer.parseInt(m.group()));
        }
        return result;
    }


}
