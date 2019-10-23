import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW6719 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_6719.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N,K;
            N = sc.nextInt();
            K = sc.nextInt();
            ArrayList <Integer> arr = new ArrayList<>();
            for(int i = 0 ; i < N; i++){
                int temp;
                temp = sc.nextInt();
                arr.add(temp);
            }
            Collections.sort(arr);
            float A = 0;
            for(int start = (N-K); start < N; start++){
                A = (A+arr.get(start))/2;
            }
            System.out.println("#"+test_case+" "+String.format("%.6f",A));
        }
    }

}