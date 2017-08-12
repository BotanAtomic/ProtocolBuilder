package org.graviton.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * Created by Botan on 12/08/2017 : 20:09
 */
public class StringUtils {

    public static String[] splitCharacter(String regex, char split, int index) {
        AtomicInteger counter = new AtomicInteger(0);
        AtomicReference<String[]> result = new AtomicReference<>();

        IntStream.range(0, regex.length()).forEach(i -> {
            if (regex.charAt(i) == split) {
                counter.incrementAndGet();
                if (index == counter.get())
                    result.set(new String[]{cut(regex, 0, i), cut(regex, i, regex.length())});
            }
        });

        return result.get();
    }

    private static String cut(String data, int start, int end) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(start, end).forEach(i -> builder.append(data.charAt(i)));
        return builder.toString().trim();
    }

    public static int countRealCharacter(String line) {
        return line.replace(" ","").length();
    }
}
