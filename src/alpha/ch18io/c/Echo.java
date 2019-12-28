package alpha.ch18io.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Echo {

    public static void main(String[] args) throws Exception{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while((s = stdin.readLine()) != null && s.length() != 0){
            System.out.println(s);
        }
    }
}
