package alpha.ch18io.enio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件允许我们创建和修改那些因为太大而不能放入内存的文件。
 * 有了内存映射文件，我们就可以假定整个文件都放在内存中，而且可以完全把它当作非常大的数组来访问。
 * 这种方法极大地简化了用于修改文件的代码。
 */
public class MappedIO {

    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    // 抽象内部类的方式组织
    private abstract static class Tester{
        private String name;
        public Tester(String name){
            this.name = name;
        }
        public void runTest(){
            System.out.print(name + " : ");
            try{
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration/1.0e9);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        public abstract void test() throws IOException;
    }

    private static Tester[] tests = {
            new Tester("Stream Write"){
                @Override
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(new FileOutputStream(new File("temp.tmp")))
                    );
                    for(int i=0; i<numOfInts; i++){
                        dos.writeInt(i);
                    }
                    dos.close();
                }
            },
            new Tester("Mapped Write"){
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    for(int i=0; i<numOfInts; i++){
                        ib.put(i);
                    }
                    fc.close();
                }
            },
            // ================================================
            new Tester("Stream Read"){
                @Override
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(new FileInputStream(new File("temp.tmp")))
                    );
                    for(int i=0; i<numOfInts; i++){
                        dis.readInt();
                    }
                    dis.close();
                }
            },
            new Tester("Mapped Read"){
                @Override
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(new File("temp.tmp")).getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                    for(int i=0; i<numOfInts; i++){
                        ib.get();
                    }
                    fc.close();
                }
            },
            // ================================================
            new Tester("Stream Read / Write"){
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(new File("temp.tmp"), "rw");
                    raf.writeInt(1);
                    for(int i=0; i<numOfUbuffInts; i++){
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read / Write"){
                @Override
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                    ib.put(0);
                    for(int i=1; i<numOfUbuffInts; i++){
                        ib.put(ib.get(i-1));
                    }
                    fc.close();
                }
            }

    };

    public static void main(String[] args) {
        for(Tester test : tests){
            test.runTest();
        }
    }
}

/**
 * out :
 * Stream Write : 0.46
 * Mapped Write : 0.04
 * Stream Read : 0.70
 * Mapped Read : 0.01
 * Stream Read / Write : 4.40
 * Mapped Read / Write : 0.01
 */
