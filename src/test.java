import java.util.Random;
import java.io.*;
public class test {
    public static void main(String[] args) throws Exception {
        File f = new File("./src/random.txt");
        Random random = new Random();
        BufferedWriter wr = new BufferedWriter(new FileWriter(f));
        for(int i = 0; i< 100000; i++){
            wr.write((random.nextInt(100000)+1)+ " ");
        }
    }
}
