package com.monkey1024.util;

import com.monkey1024.bean.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataUtil {

    private static HashMap<String, User> dataMap = new HashMap<>();

    static {
        User user1 = new User("jack", "15366189855", "南京", LocalDate.parse("2010-11-11"));
        User user2 = new User("andy", "15366189855", "东京", LocalDate.parse("2011-11-11"));
        User user3 = new User("rose", "15366189855", "上海", LocalDate.parse("2012-11-11"));
        User user4 = new User("allen", "15366189855", "广州", LocalDate.parse("2013-11-11"));

        dataMap.put("1", user1);
        dataMap.put("2", user2);
        dataMap.put("3", user3);
        dataMap.put("4", user4);
    }

    public static HashMap<String, User> findAll() {
        return dataMap;
    }

    public static User findById(String id) {
        return dataMap.get(id);
    }

    public static void create(User user) throws Exception {
        Set<Map.Entry<String, User>> entries = dataMap.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();

        int max = 0;

        while (iterator.hasNext()) {
            Map.Entry<String, User> next = iterator.next();
            int i = Integer.parseInt(next.getKey());
            if (i > max) {
                max = i;
            }
        }

        dataMap.put(++max + "", user);
    }

    public static void update(String id, User user) {
        dataMap.put(id, user);
    }

    public static void delete(String id) {
        dataMap.remove(id);
    }
}
