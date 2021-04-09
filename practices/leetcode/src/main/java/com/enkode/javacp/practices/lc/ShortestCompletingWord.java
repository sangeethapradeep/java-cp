package com.enkode.javacp.practices.lc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Given a string licensePlate and an array of strings words, find the shortest completing word in
 * words. A completing word is a word that contains all the letters in licensePlate. Ignore numbers
 * and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than
 * once in licensePlate, then it must appear in the word the same number of times or more. For
 * example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c'
 * twice. Possible completing words are "abccdef", "caaacab", and "cbca". Return the shortest
 * completing word in words. It is guaranteed an answer exists. If there are multiple shortest
 * completing words, return the first one that occurs in words.
 *
 * Test Case:
 * <p>
 * 1s3 PSt [step,steps,stripe,stepple]
 * <p>
 * 1s3 456 [looks,pest,stew,show]
 * <p>
 * Ah71752 [suggest,letter,of,husband,easy,education,drug,prevent,writer,old]
 * <p>
 * OgEu755 [enough,these,play,wide,wonder,box,arrive,money,tax,thus]
 * <p>
 * iMSlpe4 [claim,consumer,student,camera,public,never,wonder,simple,thought,use]
 */

public class ShortestCompletingWord {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String licensePlate = br.readLine();
        String[] words = br.readLine().split(",");
        shortestCompletingWord(licensePlate, words);
        System.out.println(sb);
    }

    private static void shortestCompletingWord(String licensePlate, String[] words) {
        String shortestWord = null;
        String lettersOfLicense = licensePlate.replaceAll("[^a-zA-Z]+", "").toLowerCase();
        for (String word : words) {
            boolean isCompletingWord = isCompletingWord(lettersOfLicense, word);
            if (isCompletingWord) {
                if (shortestWord == null) { shortestWord = word; } else {
                    shortestWord = shortestWord.length() > word.length()
                            ? word
                            : shortestWord;
                }
            }
        }
        sb.append(shortestWord);
    }

    private static boolean isCompletingWord(String lettersOfLicense, String word) {
        boolean isCompletingWord = true;
        for (char ch : lettersOfLicense.toCharArray()) {
            if (word.indexOf(ch) == -1 || (frequecnyOfChar(ch, word) < frequecnyOfChar(ch,
                    lettersOfLicense))) {
                isCompletingWord = false;
                break;
            }
        }
        return isCompletingWord;
    }

    private static int frequecnyOfChar(char ch, String word) {
        int frequency = 0;
        for (char c : word.toCharArray()) {
            frequency = c == ch
                    ? ++frequency
                    : frequency;
        }
        return frequency;
    }
}


