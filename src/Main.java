import com.cixin.EffectiveJava.Builder.Person;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class A {
    InvocationHandler id;
}
class B extends A{
    B() {
        System.out.println("B");
    }
}
class C extends A{
    C() {
        System.out.println("C");
    }
}
public class Main {

    public static void qiuou() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = str.length();
        int sum = 0;
        for(int i = 0;i<length;i++) {
            for(int j = 0;j<length-i+1;j++) {
                String s = str.substring(i, i+j);
                if(s.length()<=0) {
                    continue;
                }
                HashMap hm = new HashMap();
                if(Main.isO(s)) {
                    sum++;
                }
            }
        }
        System.out.print(sum);
    }
    public static boolean isO(String str) {
        HashMap hm = new HashMap();
        for(int i = 0;i<str.length();i++) {
            if(!hm.containsKey(str.charAt(i))) {
                hm.put(str.charAt(i), str.charAt(i));
            }
            else{
                hm.remove(str.charAt(i), str.charAt(i));
            }
        }
        if(hm.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void showTime() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        String timeN = in.nextLine();
        String[] timeMs = new String[M];
        int i = 0;
        while(in.hasNext()) {
            timeMs[i] = in.nextLine();
            i++;
        }
        String[] timeNs = timeN.split(",");

    }
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //System.out.println(str);
        String[] strs = str.split(" ");
        StringBuffer newStr = new StringBuffer();
        for(int i = 0;i<strs.length;i++) {
            StringBuffer sb = new StringBuffer(strs[i]);
            newStr = newStr.append(sb.reverse()+" ");
        }
        System.out.println(newStr.toString().substring(0, str.length()));
    }
    */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Class clazz = Class.forName("com.cixin.EffectiveJava.Builder.Person");
        //Person a = (Person)clazz.newInstance();
        System.out.print(solutions(""));
    }
        public static String solutions (String str) {
            int l = str.length();
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<l;) {
                int j = i+1;
                char cc = str.charAt(i);
                for(;j<l;j++) {
                    if(str.charAt(j)!=cc) {
                        break;
                    }
                }
                sb.append(""+(j-i));
                sb.append(cc);
                i = j;
            }
            return sb.toString();
        }


}
