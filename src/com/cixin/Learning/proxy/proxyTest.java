package com.cixin.Learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IUserDao {

    void save();
}

class UserDao implements IUserDao {
    public void save() {
        System.out.println("----�Ѿ���������!----");
    }
}

public class proxyTest {
    public static void main(String[] args) {
        // Ŀ�����
        IUserDao target = new UserDao();
        // ��ԭʼ������ class cn.itcast.b_dynamic.UserDao��
        System.out.println(target.getClass());

        // ��Ŀ����󣬴����������
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   �ڴ��ж�̬���ɵĴ������
        System.out.println(proxy.getClass());

        // ִ�з���   ���������
        proxy.save();
    }
}
class ProxyFactory{

    //ά��һ��Ŀ�����
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    //��Ŀ��������ɴ������
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("��ʼ����2");
                        //ִ��Ŀ����󷽷�
                        Object returnValue = method.invoke(target, args);
                        System.out.println("�ύ����2");
                        return returnValue;
                    }
                }
        );
    }

}