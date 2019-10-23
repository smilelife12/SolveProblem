import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW3367 {
    public static LinkedList<Integer> arr;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_3367.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int K;
            K = sc.nextInt();
            arr = new LinkedList<>();
            for(int i = 0 ; i < K; i++){
                int temp;
                temp = sc.nextInt();
                arr.add(temp);
            }
            Collections.sort(arr);
            int ans = 0;
            while(arr.size() != 1){
                int a = arr.removeFirst();
                int b = arr.removeFirst();
                int sum = a+b;
                ans += sum;
                if (arr.isEmpty() || sum > arr.getLast()){
                    arr.addLast(sum);
                }
                else{
                    for(int i = 0 ; i < arr.size() ; i++){
                        if (sum < arr.get(i)){
                            arr.add(i, sum);
                            break;
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }

}