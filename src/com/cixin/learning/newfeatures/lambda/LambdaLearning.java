package com.cixin.learning.newfeatures.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaLearning {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(null, 1, null, 8,2,3,66,123,123,123,123,123,123,123,123,123,123,123,12,123,123,123,123);
        int c = 1;

        list.stream().sequential().distinct().filter(a->a!=null).map(a->a+"*").peek(a->System.out.println(a.equals("1*"))).skip(0).limit(5).forEach(System.out::println);

        System.out.println();

        list.stream().parallel().distinct().filter(a->a!=null).map(a->a+"*").peek(a->System.out.println(a.equals("1*"))).skip(0).forEach(System.out::println);

        if(c==1) {
            return;
        }
        String str1 = "str1";
        String str2 = "str2";
        System.out.println("main result:\n\t"+LambdaLearning.methodOne((s1, s2)->{return s1+s2;}, str1, str2));

        // 匿名内部类排序
        String[] ss = {"1", "2"};
        //List<PersonInfo> personInfos = Arrays.asList(new PersonInfo("1", "Jerry", 10), new PersonInfo("2", "Tom",12));
        List<PersonInfo> personInfos = new ArrayList<>();
        personInfos.add(new PersonInfo("3", "C", 14));
        personInfos.add(new PersonInfo("1", "B", 12));
        personInfos.add(new PersonInfo("2", "A", 13));
        Collections.sort(personInfos, new Comparator<PersonInfo>() {
            @Override
            public int compare(PersonInfo pi1, PersonInfo pi2) {
                return pi1.getName().compareTo(pi2.getName());
            }
        });
        for(PersonInfo pi:personInfos) {
            System.out.println(pi.getId());
        }
        // Lambda排序
        Collections.sort(personInfos, (d1, d2)->{return d1.getAge()-d2.getAge();});
        personInfos.sort((pi1, pi2)->{return pi1.getAge()-pi2.getAge();});
        Collections.sort(personInfos, Comparator.comparing(PersonInfo::getAge));
        Collections.sort(personInfos, Comparator.comparing(p->p.getAge()));
        Collections.sort(personInfos, (pi1, pi2)->{return pi1.getAge()-pi2.getAge();});
        personInfos.sort(PersonInfo::compareByAge);

        personInfos.forEach(System.out::println);
        //personInfos.removeIf(p->p.getAge()>13);

        for(PersonInfo d:personInfos) {
            System.out.println(d.getId());
        }

        System.out.println(" ");
        HashMap<Integer, PersonInfo> personMap = new HashMap<>();
        personMap.put(1, new PersonInfo("3", "C", 14));
        personMap.put(2, new PersonInfo("1", "B", 12));
        personMap.put(3, new PersonInfo("2", "A", 13));
        for(Map.Entry e : personMap.entrySet()) {
            System.out.println(e.getKey());
        }
        System.out.println(" ");

        Map<Integer, PersonInfo> personMap2 = personInfos.stream().collect(Collectors.toMap(PersonInfo::getAge, Function.identity()));
        personMap2.put(133, new PersonInfo("311", "C", 15));
        personMap2.forEach((k, v)->System.out.println(k+"  "+v));

        //List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        personInfos.stream().map(p-> {return new PersonInfo(p.getId(), p.getName(), p.getAge()+1);}).forEach(p->System.out.println(p.getAge()));

        List<Integer> integerList = Arrays.asList(1, 2, 3, 8, 9, 6, 4, 2, 3, 7, 6);

        System.out.println();
        personInfos.stream().forEach(p->System.out.println(p.getAge()));
        double av = personInfos.stream().mapToInt(p->p.getAge()).average().getAsDouble();
        System.out.println(av);

        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 2).filter(p->p>3).count());
        Stream.of(1, 2, 3, 2).distinct().forEach(System.out::println);
        Stream.of(1, 2, 3, 2).distinct().map(p->p).collect(Collectors.toList());
        //Stream.generate(Math::random).forEach(System.out::println);
        //Stream.iterate(1, x->x+1).forEach(System.out::println);

        int[] asc = {1, 2, 3};
        Stream.of(asc).count();
        // flatMap() 多个容器扁平化
        List<List<PersonInfo>> persionLists = new ArrayList<>();
        persionLists.add(Arrays.asList(new PersonInfo("1", "1_1", 11)));
        persionLists.add(Arrays.asList(new PersonInfo("2", "2_1", 12), new PersonInfo("3", "2_2", 13)));
        persionLists.add(Arrays.asList(new PersonInfo("4", "3_1", 11), new PersonInfo("5", "3_2", 12), new PersonInfo("6", "3_3", 13)));
        long i = persionLists.stream().flatMap(lists->lists.stream()).count();
        System.out.println(i);
        System.out.println(persionLists.stream().count());
int is = 1;
        Stream.of(1, 2, 3, 4).mapToInt(p->p).forEach(System.out::println);
        //persionLists.stream().mapToInt()
        test1 t = ()->System.out.println("test1");

    }


    private static String methodOne(MyLambda ml, String str1, String str2) {
        return ml.defaultMethod(str1, str2);
    }

}

// Lambda接口
/*
* Lambda接口中只能定义一个抽象接口，如果定义多个，无法使用Lambda相关技巧，如果被@FunctionalInterface注释会报错
* 被@FunctionalInterface注释后，相当于在编译之前限定了接口只能有一个方法
* 注意！！：一个方法的限制中，不包括static方法和默认方法，且不包含继承自Object中的方法
* */
@FunctionalInterface
interface MyLambda {
    default String defaultMethod(String str1, String str2) {
        System.out.println("MyLambda defaultMethod:\n\t"+str1+"+"+str2);
        return str1+str2;
    }
    static String staticMethod(String str1, String str2) {
        System.out.println("MyLambda staticMethod:\n\t"+str1+"+"+str2);
        return str1+str2;
    }
    String Method(String str1, String str2);
}

interface test1 {
    public void cs();
}

interface test2 {
    IntStream mapToInt(test1 mapper);
}


/**
 * PersonInfo类：作为Lambda学习时的基本数据
 */
class PersonInfo {
    private String id;
    private String name;
    private int age;

    public PersonInfo() {
        super();
    }

    public PersonInfo(final String id, final String name, final int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static int compareByAge(PersonInfo pi1, PersonInfo pi2) {
        return pi1.age-pi2.age;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}