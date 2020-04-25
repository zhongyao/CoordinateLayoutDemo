package com.example.coordinate.util;

import java.util.ArrayList;

public class DataUtil {

    public static ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("哈哈" + i);
        }
        return list;
    }
}
