package alpha.ch18io.h;

import java.util.prefs.Preferences;

/**
 * 操作系统会保存相关值
 */
public class PreferencesDemo {

    public static void main(String[] args) throws Exception{

        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);

        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches ?", true);

        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);

        for(String key : prefs.keys()){
            System.out.println(key + " : " + prefs.get(key, null));
        }

        // you must always provide a default value
        System.out.println("How many companions does Dorothy have ? " + prefs.getInt("Companions", 0));
    }
}
