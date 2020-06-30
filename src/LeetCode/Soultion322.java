package LeetCode;

public class Soultion322 {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0)
            return 0;
//        int res = Integer.MAX_VALUE;
        int[] demos = new int[amount+1];
//        res = Math.min(helper(coins,amount,demos), res);
//        return res==Integer.MAX_VALUE ? -1 : res;
        return helper(coins, amount, demos);
    }
    public int helper(int[] coins, int amount, int[] demo) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (demo[amount] != 0)
            return demo[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = helper(coins,amount-coin,demo);
            if (sub == -1)
                continue;
            if (sub >= 0 && sub < min)
                min = 1 + sub;
        }
        demo[amount] = min == Integer.MAX_VALUE? -1 : min; //之前写在for里面 超时
        return demo[amount];
    }
}
