package LeetCode;

import java.util.HashMap;

public class Soultion76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character,Integer> windows = new HashMap<>();

        int match = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        //+
        int left = 0;
        int right = 0;

        char[] ts = t.toCharArray();
        char[] ss = s.toCharArray();

        for (char c : ts) {
            needs.put(c,needs.getOrDefault(c,0)+1);
        }

        while (right<s.length()) {
            char c = ss[right];

            if (needs.containsKey(c)) {
                windows.put(c,windows.getOrDefault(c,0)+1);
                if (needs.get(c).compareTo(windows.get(c)) == 0)     //************包装类Integer用==会出错
                    match++;
            }
            right++;

            while (match == needs.size()) {
                char _c = ss[left];
                if (needs.containsKey(_c)) {
                    windows.put(_c,windows.getOrDefault(_c,0)-1);
                    if (windows.get(_c) < needs.get(_c))
                        match--;
                }


                if (minLen > (right-left)) {
                    //+
                    start = left;
                    minLen = right-left;
                }
                //改位置
                left++;
            }

        }
        return minLen==Integer.MAX_VALUE? "":s.substring(start,start+minLen);
    }
}
