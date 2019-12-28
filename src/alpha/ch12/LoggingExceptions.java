package alpha.ch12;

import org.w3c.dom.ls.LSOutput;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {

    public static void main(String[] args) {
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Cautht " + e);
        }
        try{
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Cautht " + e);
        }

        System.out.println("=======================================================");

        f();
    }

    static void f(){
        System.out.println(1/0);
    }

}
