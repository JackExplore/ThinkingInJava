package alpha.ch18io.a;

import java.io.File;

public class DirectoryDemo {

    public static void main(String[] args) {

        // All directories :
        PPrint.pprint(Directory.walk(".").dirs);
        System.out.println("======================================");
        // All files beginning with 'T'
        for(File file : Directory.local(".", "T.*")){
            System.out.println(file);
        }
        System.out.println("======================================");
        // All Java files beginning with 'T'
        for(File file : Directory.local(".", "T.*\\.java")){
            System.out.println(file);
        }
        // Class files containing "Z" or "z"
        System.out.println("======================================");
        for(File file : Directory.local(".", ".*[Zz].*\\.class")){
            System.out.println(file);
        }

    }
}
