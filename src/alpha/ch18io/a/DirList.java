package alpha.ch18io.a;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
            /**
             *     public String[] list(FilenameFilter filter) {
             *         String names[] = list();
             *         if ((names == null) || (filter == null)) {
             *             return names;
             *         }
             *         List<String> v = new ArrayList<>();
             *         for (int i = 0 ; i < names.length ; i++) {
             *             if (filter.accept(this, names[i])) {
             *                 v.add(names[i]);
             *             }
             *         }
             *         return v.toArray(new String[v.size()]);
             *     }
             */
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}


class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    /**
     * 这是一个回调函数
     * 具体的说，这是策略模式，策略的目的就是提供了代码行为的灵活性
     * @param dir
     * @param name
     * @return
     */
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}