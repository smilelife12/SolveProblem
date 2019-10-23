import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW4050 {
    public static ArrayList<Integer> list;
    public static int N;
    public static int sum;
    public static int discount;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_4050.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            sum = 0;
            discount = 0;
            list = new ArrayList<>();
            for(int i = 0 ; i < N; i++){
                int temp = sc.nextInt();
                list.add(temp);
                sum += temp;
            }
            Collections.sort(list);
            int min = 999999;
            int cnt = 1;
            while(!list.isEmpty()){
                int temp = list.remove(list.size()-1);
                if (temp < min){
                    min = temp;
                }
                if (cnt == 3) {
                    cnt = 1;
                    discount += min;
                    min = 999999;
                }
                else {
                    cnt++;
                }
            }
            int ans = sum - discount;
            System.out.println("#"+test_case+" "+ans);
        }
    }

}