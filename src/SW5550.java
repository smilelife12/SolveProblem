import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW5550 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_5550.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            LinkedList<Boolean> frogs = new LinkedList<>();
            int frog = 0;
            String cries;
            cries = sc.next();

            int [] count = {0,0,0,0,0};
            int sang = 0;
            for(int i = 0 ; i < cries.length(); i++){
                char temp = cries.charAt(i);
                int idx;
                switch (temp){
                    case 'c': idx=0;break;
                    case 'r': idx=1;break;
                    case 'o': idx=2;break;
                    case 'a': idx=3;break;
                    default: idx=4;
                }
                if(idx == 0){
                    if(sang > 0){
                        frogs.addLast(true);
                        sang -= 1;
                    }
                    else{
                        frogs.addLast(false);
                    }
                    count[idx] += 1;
                }
                else{
                    if (count[idx - 1] > count[idx]) {
                        count[idx] += 1;
                    }
                    else{
                        frog = -1;
                        break;
                    }
                }
                if (count[4] == 1){
                    for(int k = 0 ; k<5;k++) count[k] -=1;
                    boolean t = frogs.removeFirst();
                    if (!t){
                        frog +=1;
                    }
                    sang +=1;
                }
            }
            if (frog == 0){
                frog = -1;
            }
            else if(count[0] > 0){
                if(frog == 1 || sang >0) {
                    frog = -1;
                }
            }
            System.out.println("#"+test_case+" "+frog);
        }
    }
}