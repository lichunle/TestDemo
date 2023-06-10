package com.example.demo.collection;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Demo1 {

//    static {
//        i = 1;
//        System.out.println(i);
//    }
//    private static int i = 0;

    public static void main(String[] args) {


//
//        Person p1 = new Person("zhangsan", 1);
//        Person p2 = new Person("zhangsan", 1);
//        Person p3 = new Person("lisi", 1);
//
//        HashSet set = new HashSet();
//        set.add(p1);
//        set.add(p2);
//        set.add(p3);
//
//        // 比较p1 和 p2， 并打印它们的hashCode()
//        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
//        // 比较p1 和 p4， 并打印它们的hashCode()
//        System.out.printf("p1.equals(p4) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
//        // 打印set
//        System.out.printf("set:%s\n", set.toString());
//
//        List list = new ArrayList<>();
        Map map = new HashMap();
        StringBuffer sBuffer = new StringBuffer();
//

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.add(1);
//        list2.add(3);
//        list2.add(4);
//        list2.add(5);
//        Collections.sort(list2, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });

//        Collections.sort(list2, (Integer o1, Integer o2) -> {
//            return o2-o1;
//        });
//
//        Collections.sort(list2, (Integer o1, Integer o2) -> o2.compareTo(o1));
//        System.out.println(Arrays.toString(list2.toArray()));

        // 交集
//        list1.retainAll(list2);

        // 并集 -重复
//        list1.addAll(list2);
        // 并集 -不重复
//        list1.removeAll(list2);
//        list1.addAll(list2);
        // 差集
//        list1.removeAll(list2);
//        list2.removeAll(list1);
//        List<Integer> tList = list2.parallelStream().distinct().collect(Collectors.toList());
////
//        tList.stream().forEach((o) -> {
//            System.out.println(o.intValue());
//        });
//        Long l1 = new Long(7);
//        Long l2 = 7L;
//        System.out.println(l1 == l2);

//        Vector
//        HashSet
//        Queue
//        try {
//            testArrayList();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        testHashMap();
//        testHashSet();
//        String str = reversePrefix("xyxzxe",'z');
//        System.out.println(isSubsequence("abc", "ahbgdc"));
        long sqrt = (long) Math.sqrt(180);
        System.out.println(sqrt);

    }
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index < 0) {
            return word;
        }
        String firstStr = new StringBuffer(word.substring(0, index+1)).reverse().toString();
        String lastStr = word.substring(index+1, word.length());
        return firstStr+lastStr;
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }



    public static void testArrayList() throws IOException {
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.add(1);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(list.getClass());
//        int n = 10000000;
//        list.ensureCapacity(10000001);
//        long startTime = System.currentTimeMillis();
//
//        for(int i = 0;i < n ;i++) {
//            list.add(i+"");
//        }
//        System.out.println("before:" + (System.currentTimeMillis()-startTime));

    }

    public static void testArrayList(int a) throws Exception {

    }


    public static void testQueue() {

        Queue queue = new PriorityQueue();
    }

    public static void testHashMap() {
        System.out.println("========================");
//        Map<User, Object> map = new HashMap<>(2);
//
//        for(int i = 0;i < 20;i++) {
//            User user = new User();
//            map.put(user, i);
//        }
//        map.isEmpty();
//        map.put("2", 2);
//        map.put("3", 3);
//        map.put("4", 4);
//        map.put("5", 5);

        ConcurrentHashMap tMap = new ConcurrentHashMap<>();
        tMap.put("1", 1);
        tMap.isEmpty();
    }

    public static void testHashSet() {

        HashSet set = new HashSet();
        boolean s = set.add(1);
        boolean s1 = set.add(1);
    }

    public static void testLinkedList() {

        List<String> linkList = new LinkedList<>();
//        linkList.add()
    }

    public static void passwordTrans(String str) {

        char[] a = {'A','B','C','D','E'};
        char[] b = {'b','c','d','e','f'};

        for(int i = 0;i < str.length();i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
//                str[i] = b[c-'a'+26];
            }
        }
    }
}
