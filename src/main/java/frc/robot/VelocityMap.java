package frc.robot;

import java.util.NavigableMap;
import java.util.TreeMap;

public class VelocityMap {
    public static NavigableMap<Integer, Double> map = new TreeMap<Integer, Double>();

    static {
        map.put(0, 200.0);
        map.put(3, 400.0);
        map.put(5, 600.0);
        map.put(8, 800.0);
        map.put(10, 1000.0);
    }   
}