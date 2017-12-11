package com.cixin.Learning.proxy.jdk;

import java.io.Serializable;
import java.lang.ref.PhantomReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author cixinxc
 */
public class JdkProxyTest implements Serializable {
    static int i = 1;
    static {
        i = 0;
        int j = 1;
        System.out.println(i);
        ArrayList<String> a = new ArrayList();
        a.add("1");
        Vector<String> as = new Vector();
        as.add("1");
    }



    public static void main(String[] args) throws Exception {
        /*
        Map<String,? super A> map = new HashMap<>();
        map.put("1", new A1("1"));
        map.put("2", new A2("2"));
        map.put("2", new A2("2"));
        System.out.println(((A1)map.get("1")).name);
        System.out.println(((A2)map.get("2")).name);
*/

        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CustomInvocationHandler handler = new CustomInvocationHandler(new HelloImpl());
        Hello proxy = (Hello) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[]{Hello.class}, handler);
        proxy.hello("cxx");
    }
}
enum as{
    a;
}

class A{
    public String name;
    public A(){}
    public A(String name) {
        this.name = name;
    }

}
class A1 extends A{

    public A1(String name) {
        this.name = name;
    }
}
class A2 extends A{
    public A2(String name) {
        this.name = name;
    }
}