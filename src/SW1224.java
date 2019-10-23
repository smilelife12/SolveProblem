import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1224 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1224.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N;
            N = sc.nextInt();
            String s = sc.next();
            LinkedList<Character> stack = new LinkedList<>();
            LinkedList<Character> post = new LinkedList<>();
            for(int i = 0 ; i < N; i++){
                char word = s.charAt(i);
                if(word == '('){
                    stack.addLast(word);
                }
                else if(word == ')'){
                    while(true){
                        char temp = stack.removeLast();
                        if(temp =='('){
                            break;
                        }
                        post.addLast(temp);
                    }
                }
                else if(word<='9' && word >='0'){
                    post.addLast(word);
                }
                else{
                    if(word == '*'|| word == '/'){
                        while(!stack.isEmpty() && (stack.getLast()=='*'|| stack.getLast()=='/')){
                            char temp = stack.removeLast();
                            post.addLast(temp);
                        }
                        }
                    else{
                        while(!stack.isEmpty()&&(stack.getLast()!='(')){
                            char temp = stack.removeLast();
                            post.addLast(temp);
                        }
                    }
                    stack.addLast(word);
                }
            }
            while(!stack.isEmpty()){
                post.addLast(stack.removeLast());
            }
            LinkedList<Integer> num = new LinkedList<>();
            while(!post.isEmpty()) {
                char temp = post.removeFirst();
                if(temp <= '9' && temp >= '0'){
                    num.addLast(temp-'0');
                }
                else{
                    int num2 = num.removeLast();
                    int num1 = num.removeLast();
                    if(temp == '+'){
                        num.addLast(num1+num2);
                    }
                    else if(temp == '-'){
                        num.addLast(num1-num2);
                    }
                    else if(temp == '*'){
                        num.addLast(num1*num2);
                    }
                    else{
                        num.addLast(num1/num2);
                    }
                }
            }

            System.out.println("#"+test_case+" "+num.getLast());
        }
    }

}