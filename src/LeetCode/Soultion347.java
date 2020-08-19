package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soultion347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequences = new HashMap<>();
        for (int num : nums) {
            frequences.put(num, frequences.getOrDefault(num,0)+1);
        }
        List<Integer>[] tongs = new ArrayList[nums.length+1];
        for (int key : frequences.keySet()) {
            int frequence = frequences.get(key);
            if (tongs[frequence] == null) {
                tongs[frequence] = new ArrayList<>();
            }
            tongs[frequence].add(key);
        }

//        int[] res = new int[k];
        List<Integer> res = new ArrayList<>();
        for (int i=nums.length; i>0 && res.size() < k; i--) {
            if (tongs[i] == null)
                continue;
            if (k - tongs[i].size() - res.size() > 0) {
                res.addAll(tongs[i]);
            } else {
                res.addAll(tongs[i].subList(0,k-res.size()));
            }
        }

        int[] res_ = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            res_[i] = res.get(i);
        }
        return res_;
    }
}
