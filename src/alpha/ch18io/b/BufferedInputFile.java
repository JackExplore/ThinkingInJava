package alpha.ch18io.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入文件
 */
public class BufferedInputFile {

    public static String read(String filename) throws IOException{
        // Reading input by lines :
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null){
            sb.append(s + "\n");    // 此处添加换行符，因为 readLine() 已经把它们删掉
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        System.out.print(read("ThinkingInJava.iml"));
    }
}
