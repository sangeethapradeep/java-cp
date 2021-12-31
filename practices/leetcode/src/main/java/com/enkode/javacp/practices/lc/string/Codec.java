package com.enkode.javacp.practices.lc.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 535
 *
 * <pre>
 *     Test Cases:
 *          url = "https://leetcode.com/problems/design-tinyurl"
 * </pre>
 */
public class Codec {
  static Map<String, String> encodedMap = new HashMap<>();
  static String baseUrl = "http://tinyurl.com/";

  public static void main(String[] args) {
    String url = "https://leetcode.com/problems/design-tinyurl";
    System.out.println("Original: " + url);
    System.out.println("Encoded: " + encode(url));
    System.out.println("Decoded: " + decode(encode(url)));
  }

  // Encodes a URL to a shortened URL.
  private static String encode(String longUrl) {
    String shortUrl = baseUrl + Integer.toHexString(longUrl.hashCode());

    encodedMap.put(shortUrl, longUrl);
    return shortUrl;
  }

  // Decodes a shortened URL to its original URL.
  private static String decode(String shortUrl) {
    return encodedMap.get(shortUrl);
  }
}
