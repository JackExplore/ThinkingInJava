package alpha.ch18io.c;

import java.io.*;

/**
 * 标准 IO 重定向
 * IO 重定向操纵的是字节流，而不是字符流
 */
public class Redirecting {
    public static void main(String[] args) throws Exception {

        PrintStream console = System.out;

        BufferedInputStream in = new BufferedInputStream(new FileInputStream("ThinkingInJava.iml"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            System.out.println(s);
        }
        out.close();
        in.close();
        System.setOut(console);
    }
}
