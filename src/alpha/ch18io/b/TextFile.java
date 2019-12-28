package alpha.ch18io.b;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {

    // Read a file as a single string :
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try{
            in = new BufferedReader(new FileReader(filename));
            String s;
            while((s = in.readLine()) != null){
                sb.append(s + "\n");    // 此处添加换行符，因为 readLine() 已经把它们删掉
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    // Write a single file in one method call :
    public static void write(String fileName, String text){
        try{
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            out.print(text);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public TextFile(String fileName, String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        // regular expression split() often leaves an empty
        // String at the first position :
        if(get(0).equals(" ")) remove(0);
    }

    public TextFile(String fileName){
        this(fileName, "\n");
    }

    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            for(String item : this){
                out.println(item);
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("ThinkingInJava.iml");
        write("test.txt", file);

        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");

        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile("ThinkingInJava.iml", "\\W+"));

        System.out.println(words.headSet("a"));
    }
}
