package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
class Employee{

    private String id ;
    public String name ;
    private  String password ;

    Employee(String id,String name){
        this.name = name ;
        this.id = id ;
    }


    public String getPassword(){
        return this.password;
    }

    public String getId(){
        return this.id ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class BasicExample {


    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflection.Employee");

        System.out.println(Arrays.asList(clazz.getFields()));

        System.out.println(Arrays.asList(clazz.getDeclaredFields()));

        System.out.println(Arrays.asList(clazz.getDeclaredMethods()));

        Method method = clazz.getMethod("setPassword", String.class);
        Field idField = clazz.getDeclaredField("id") ;

        Employee employee = (Employee) clazz.getDeclaredConstructor(new Class[] {String.class,String.class}).newInstance(new Object[] {"a","b"});
        method.setAccessible(true);
        idField.setAccessible(true);
        method.invoke(employee, "hello");
        idField.set(employee,"achanged");
        System.out.println(employee.getPassword());
        System.out.println(employee.getId());
    }
}
