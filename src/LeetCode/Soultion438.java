package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Soultion438 {
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        Soultion438 s1 = new Soultion438();
        System.out.println(s1.findAnagrams(s,p));
    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> needs = new HashMap<>();
        HashMap<Character,Integer> windows = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        int matchs = 0;
        for (int i=0; i<p.length(); i++) {
            char index = p.charAt(i);
            needs.put(index,needs.getOrDefault(index,0)+1);
        }

        while (right < s.length()) {
            char c_r = s.charAt(right);

            if (needs.containsKey(c_r)) {
                windows.put(c_r, windows.getOrDefault(c_r,0)+1);
                if (needs.get(c_r).compareTo(windows.get(c_r)) == 0)
                    matchs++;
            }
            right++;

//            if (needs.get(c_r).compareTo(windows.get(c_r)) == 0){
//                matchs++;
//            }
            while (matchs == needs.size()) {
                char c_l = s.charAt(left);
                if (right-left==p.length())
                    res.add(left);

                if (needs.containsKey(c_l)) {
                    windows.put(c_l,windows.getOrDefault(c_l,0)-1);
                    if (windows.get(c_l) < needs.get(c_l))
                        matchs--;
                }

                left++;
            }
        }

        return res;
    }
}
