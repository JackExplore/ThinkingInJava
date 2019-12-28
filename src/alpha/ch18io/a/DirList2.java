package alpha.ch18io.a;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 匿名内部类形式
 */
public class DirList2 {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

    public static FilenameFilter filter(final String regex){
        // creating of anonymous inner class
        return new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);   // 必须是 final？!
            @Override
            public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
            }
        }; // end of anonymous inner class
    }
}
