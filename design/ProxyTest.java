import java.lang.reflect.Proxy;

/**
 * className$menthodName=aaa
 * 代理获取执行结果
 **/
public class ProxyTest {

    public static Object createObject(String str) throws Exception {
        String className = str.substring(0, str.lastIndexOf("$"));
        String methodName = str.substring(str.lastIndexOf("$") + 1, str.indexOf("=")).trim();
        Class clazz = Class.forName(className);
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            if (method.getName().equals(methodName)) {
                return str.substring(str.indexOf("=") + 1).trim();
            }
            return null;
        });
    }

}
