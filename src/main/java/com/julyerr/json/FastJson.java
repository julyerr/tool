package com.julyerr.json;

import com.alibaba.fastjson.JSON;
import com.julyerr.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJson {
    public static void main(String[] args) {
        User user = new User("julyerr", "julyerr");
        String userString = Entity2String(user);
        System.out.println(userString);
        User newUser = String2Entity(userString);
        System.out.println(newUser);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "julyerr");
        map.put("age", "123");
        List<String> list = new ArrayList<>();
        list.add("how");
        list.add("are");
        list.add("you");
        map.put("list", list);
        String mapString = JSON.toJSONString(map);
        System.out.println(mapString);
        Map<String, Object> newMap = JSON.parseObject(mapString, HashMap.class);
        List<String> newList = (List<String>) newMap.get("list");
        System.out.println(newList.size() + ":" + newList.get(0));
    }

    public static String Entity2String(User user) {
        return JSON.toJSONString(user);
    }

    public static User String2Entity(String string) {
        return JSON.parseObject(string, User.class);
    }

}
