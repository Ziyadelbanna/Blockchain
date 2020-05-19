package Peers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Peers {
    public static HashMap<String, Integer> allpeers ;
    public void addpeer (String address, Integer port){
        if (allpeers == null){
            allpeers = new HashMap<String,Integer>();
        }
        allpeers.put(address, port);
    }
    public static Set<Map.Entry<String, Integer>> getpeers() {
        return allpeers.entrySet();
    }
}
