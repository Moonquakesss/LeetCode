package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
划分字母区间
 */
public class Soultion763 {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[26];
        for (int i=0; i<S.length(); i++) {
            lastIndexOfChar[char2index(S.charAt(i))] = i;
        }
        List<Integer> slicePart = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            for (int i=firstIndex; i<S.length() && i<=lastIndex; i++) {
                int index = lastIndexOfChar[char2index(S.charAt(i))];
                if (index > lastIndex)
                    lastIndex = index;
            }
            slicePart.add(lastIndex-firstIndex+1);
            firstIndex = lastIndex+1;
        }
        return slicePart;
    }
    public int char2index(char c) {
        return c - 'a';
    }
}
