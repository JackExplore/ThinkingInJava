package alpha.ch17;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;                // 1 通过 hashcode() 获取数组下标
        if(buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];         // 2 通过下标取得对应的链表
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while(it.hasNext()){                                        // 3 遍历查找是否存在 <K, V>
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)){                         // 3.1 如果找到，则更新 V
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if(!found){                                                 // 3.2 如果没有找到，则增加
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K, V> iPair : buckets[index]){
            if(iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for(LinkedList<MapEntry<K, V>> bucket : buckets){
            if(bucket == null) continue;
            for(MapEntry<K, V> mpair : bucket){
                set.add(mpair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.put("a", "123");
        m.put("b", "234");
        m.put("c", "345");
        System.out.println(m);
        System.out.println(m.get("c"));
        System.out.println(m.get("d"));
        System.out.println(m.entrySet());

        Map mm = new HashMap();
    }
}
/* out:
{b=234, a=123, c=345}
345
null
[b = 234, a = 123, c = 345]
 */