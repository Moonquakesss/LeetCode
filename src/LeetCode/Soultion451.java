package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soultion451 {
    public static void main(String[] args) {
        String s = "cccaaa";
        Soultion451 sol = new Soultion451();
        System.out.println(sol.frequencySort(s));
    }
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> frequences = new HashMap<>();
        for (char c : chars) {
            frequences.put(c,frequences.getOrDefault(c,0)+1);
        }
        List<Character>[] baskets = new ArrayList[chars.length+1];
        for (char key : frequences.keySet()) {
            int index = frequences.get(key);
            if (baskets[index] == null) {
                baskets[index] = new ArrayList<>();
            }
            baskets[index].add(key);
        }
        String res = "";
        List<Character> res_ = new ArrayList<>();
        // i是频率 需要添加i次 相同频率的 分开add
        for (int i=baskets.length-1; i>0; i--) {
            if (baskets[i] == null)
                continue;
            for (char c_ : baskets[i]) {
                for (int j=0; j<i; j++) {
                    res_.add(c_);
                }
            }
        }
        for (int i=0; i<res_.size(); i++) {
            res += res_.get(i);
        }
        return res;
    }
}
