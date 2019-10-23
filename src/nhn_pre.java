import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class nhn_pre {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/nhn_input.txt"));

        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int W;
        W = sc.nextInt();
        int rotate = 1;
        if (W < 0){
            rotate *= -1;
        }
        W = Math.abs(W);
        String [][] list = new String[N][N];
        for(int i = 0 ; i < N; i++) {

            for (int j = 0; j < N; j++) {
                String temp = sc.next();
                list[i][j] = temp;
            }
        }
        String [][] changed = new String[N][N];
        int cnt = 0;
        while(N - cnt*2 > 1) {
            int arr_size = N-cnt*2;
            int w_cal = W%((arr_size - 1)*4);
            for(int i = 0 ; i < arr_size-1; i++){
                int [] temp = cal(0,i,arr_size,w_cal,rotate);
//                System.out.printf("before : %d, %d, after : %d, %d\n",0,i,temp[0],temp[1]);
                changed[temp[0]+cnt][temp[1]+cnt] = list[0+cnt][i+cnt];
                temp = cal(i,arr_size - 1,arr_size,w_cal,rotate);
//                System.out.printf("before : %d, %d, after : %d, %d\n",i,arr_size-1,temp[0],temp[1]);
                changed[temp[0]+cnt][temp[1]+cnt] = list[i+cnt][arr_size-1+cnt];
                temp = cal(arr_size-1 , arr_size-1 -i, arr_size,w_cal,rotate);
//                System.out.printf("before : %d, %d, after : %d, %d\n",arr_size-1,arr_size-1-i,temp[0],temp[1]);
                changed[temp[0]+cnt][temp[1]+cnt] = list[arr_size-1+cnt][arr_size-1-i+cnt];
                temp = cal(arr_size -1 -i, 0,arr_size,w_cal,rotate);
//                System.out.printf("before : %d, %d, after : %d, %d\n",arr_size-1-i,0,temp[0],temp[1]);
                changed[temp[0]+cnt][temp[1]+cnt] = list[arr_size-1-i+cnt][cnt];
//                for (String[] s:changed
//                     ) {
//                    System.out.println(Arrays.toString(s));
//                }
//                for (String[] s:list
//                ) {
//                    System.out.println(Arrays.toString(s));
//                }


            }
            cnt+=1;
            rotate*=-1;
        }
        if (N % 2 == 1){
            changed[N/2][N/2] = list[N/2][N/2];
        }
        for(String[] s: changed){
            System.out.print(s[0]);
            for (int i = 1; i < s.length; i++){
                System.out.print(" "+ s[i]);
            }
            System.out.println();
        }
    }
    public static int [] cal(int r, int c, int size, int w, int way){
        int t_x=0;
        int t_y=0;
        int cnt = 0;
        while (cnt < w){
            cnt+=1;
            if (r == 0){
                if( c ==0 && way == -1){
                    r +=1;
                }
                else if( c == size -1 && way == 1){
                    r +=1;
                }
                else{
                    c += way;
                }
            }
            else if(r == size-1){
                if( c == 0 && way == 1){
                    r -=1;
                }
                else if(c == size -1 && way == -1){
                    r -=1;
                }
                else{
                    c -=way;
                }
            }
            else if(c == 0){
                r -= way;
            }
            else{
                r += way;
            }
        }
        return new int []{r,c};
    }

}