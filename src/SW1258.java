import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1258 {
    public static int n;
    public static LinkedList<int[]> square;
    public static int [][] map, visit;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1258.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new int[n][n];
            visit = new int[n][n];
            square = new LinkedList<>();
            for(int i = 0 ; i < n; i++){
                for(int j = 0; j < n ; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0 ; j < n ; j++){
                    if(visit[i][j] == 0 && map[i][j] !=0) {
                        visit[i][j] = 1;
                        findSquare(i,j);
                    }
                }
            }
            System.out.printf("#%d %d ",test_case,square.size());
            while(!square.isEmpty()){
                int[] temp = square.removeFirst();
                System.out.printf("%d %d ",temp[0],temp[1]);
            }
            System.out.println();
        }
    }
    public static void findSquare(int r, int c){
        int minR = r, maxR = r;
        int minC = c, maxC = c;
        while (minR >0){
            if(map[minR-1][c] != 0) {
                minR-=1;
            }
            else{
                break;
            }
        }
        while (maxR < n-1){
            if(map[maxR+1][c] !=0) {
                maxR+=1;
            }
            else{
                break;
            }
        }
        while (minC >0){
            if(map[r][minC-1] != 0) {
                minC-=1;
            }
            else{
                break;
            }
        }
        while (maxC < n-1){
            if(map[r][maxC+1] !=0) {
                maxC+=1;
            }
            else{
                break;
            }
        }
        for(int i = minR; i <= maxR; i ++) {
            for (int j = minC; j <= maxC; j++) {
                visit[i][j] = 1;
            }
        }
        int sizeR = (maxR-minR+1);
        int sizeC = (maxC-minC+1);
        int size = sizeC*sizeR;
        int [] sq = new int[] {sizeR,sizeC,size};
        saveSquare(sq);
    }
    public static void saveSquare(int [] new_sq){
        if(square.isEmpty()){
            square.add(new_sq);
        }
        else {
            boolean add = false;
            for (int i = 0; i< square.size(); i++){
                int [] temp = square.get(i);
                if((temp[2] > new_sq[2])||(temp[2] == new_sq[2] && temp[0] > new_sq[0]) ){
                    square.add(i,new_sq);
                    add = true;
                    break;
                }
            }
            if(!add){
                square.addLast(new_sq);
            }
        }
    }
}