package alpha.ch18io.f;

import java.io.*;
import java.util.zip.*;

/**
 * 文件压缩
 */
public class ZipCompress {

    public static void main(String[] args) throws Exception{

        FileOutputStream f = new FileOutputStream("test.zip");

        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());

        ZipOutputStream zos = new ZipOutputStream(csum);

        BufferedOutputStream out = new BufferedOutputStream(zos);

        zos.setComment("A test of Java Zipping");

        // No corresponding getComment(), though.
        for(String arg : args){
            System.out.println("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while((c=in.read()) != -1){
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();

        // Checksum valid only after the file has been closed !
        System.out.println("Checksum : " + csum.getChecksum().getValue());
        // Now extract the files:
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while((ze = in2.getNextEntry()) != null){

        }
    }
}
