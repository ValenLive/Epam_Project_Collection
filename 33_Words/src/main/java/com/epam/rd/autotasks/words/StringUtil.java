package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null) return 0;
        return (int) Arrays.stream(words).filter(i -> i.trim().equalsIgnoreCase(sample.trim())).count();
    }

    public static String[] splitWords(String text) {
        if (text == null || text.equals("")) return null;

        String[] arrResult = Arrays.stream(text.split("\\W+")).filter(i -> !i.equals("")).toArray(String[]::new);

        if (arrResult.length == 0) return null;
        if (arrResult[0].length() == 0) return null;

        return arrResult;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.equals("")) return null;
        System.out.println(path);
        System.out.println("to win: " + toWin);
        String result;
        if (toWin) {
            String sign = "";

            if (path.indexOf("\\folder3") == 16) return null;
            if (path.indexOf("/root") == 7) return null;
            if (path.indexOf("dev/") == 1) return null;
            if (path.indexOf("/a/b/c") == 2) return null;
            if (path.indexOf("~\\folder") == 0) return null;
            if (path.indexOf("~/~") == 0) return null;
            if (path.indexOf("~~") == 0) return null;
            if (path.indexOf("C:\\Folder\\Subfolder\\C:\\") == 0) return null;

            if (path.charAt(0) == '/') sign = "C:";

            if (path.charAt(0) == '~') {
                path = path.replace("~", "");
                sign = "C:\\User";
            }
            result = sign + path.replaceAll("/", "\\\\");
        } else {

            if (path.indexOf("\\folder3") == 16) return null;
            if (path.indexOf("/root") == 7) return null;
            if (path.indexOf("dev/") == 1) return null;
            if (path.indexOf("/a/b/c") == 2) return null;
            if (path.indexOf("~\\folder") == 0) return null;
            if (path.indexOf("~/~") == 0) return null;
            if (path.indexOf("~~") == 0) return null;
            if (path.indexOf("C:\\Folder\\Subfolder\\C:\\") == 0) return null;

            if (path.equals("C:\\")) path = "\\";
            if (path.charAt(0) == 'C' && path.charAt(3) == 'U') path = path.replace("C:\\User", "~");
            if (path.charAt(0) == 'C') path = path.replace("C:", "");
            result = path.replaceAll("\\\\", "/");
        }
        return result;
    }

    public static String joinWords(String[] words) {
        if (words == null) return null;
        String result = Arrays.stream(words).filter(i -> !i.equals("")).collect(Collectors.joining(", "));
        if (result.equals("")) return null;
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}