package LeetCode;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.nextLine();
        int length = str.length();
        int max = 0;
        int temp = 0;
        for(int i=1;i<10;i++)
            for(int j=1;j<10;j++)
            {
                for(int k=1;k<9;k++)
                {
                    if(i!=j && i!=k && j!=k)
                    {
                        temp = i*100+j*10+k + i+j*100+k*10;
                        if(temp > max)
                            max = temp;
                        if(max==1875)
                            System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        System.out.println(max);
    }
}
