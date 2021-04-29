package com.enkode.javacp.practices.lc.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we
 * have "com", at the next level, we have "leetcode.com", and at the lowest level,
 * "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit
 * the parent domains "leetcode.com" and "com" implicitly.
 *
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain
 * received), followed by a space, followed by the address. An example of a count-paired domain
 * might be "9001 discuss.leetcode.com".
 *
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired
 * domains, (in the same format as the input, and in any order), that explicitly counts the number
 * of visits to each subdomain.
 *
 * Test Cases:
 *      9001 discuss.leetcode.com
 *      900 google.mail.com,50 yahoo.com,1 intel.mail.com,5 wiki.org
 * </pre>
 */

public class SubdomainVisitCount {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cpDomains = br.readLine().split(",");
        subdomainVisits(cpDomains);
        System.out.println(sb);
    }

    private static void subdomainVisits(String[] cpDomains) {
        Map<String, Integer> subDomainVisitsMap = new HashMap<>();
        List<String> subDomainVisitsList = null;
        for (String cpdomain : cpDomains) {
            int count = Integer.parseInt(cpdomain.split(" ")[0]);
            List<String> subDomains = new ArrayList<>(
                    Arrays.asList(cpdomain.split(" ")[1].split("\\.")));
            while (!subDomains.isEmpty()) {
                String subDomain = String.join(".", subDomains);
                if (subDomainVisitsMap.containsKey(subDomain)) {
                    subDomainVisitsMap.put(subDomain, subDomainVisitsMap.get(subDomain) + count);
                } else {
                    subDomainVisitsMap.putIfAbsent(subDomain, count);
                }
                subDomains.remove(0);
            }
        }
        subDomainVisitsList = subDomainVisitsMap.entrySet().stream().map(
                stringIntegerEntry -> stringIntegerEntry.getValue() + " " + stringIntegerEntry
                        .getKey()).collect(Collectors.toList());
        sb.append(subDomainVisitsList);
    }
}
