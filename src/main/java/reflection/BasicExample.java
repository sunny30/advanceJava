package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
class Employee{

    public String id ;
    public String name ;
    private  String password ;

    Employee(String id,String name){
        this.name = name ;
        this.id = id ;
    }


    public String getPassword(){
        return this.password;
    }

    public void setId(String Id){

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

        Employee employee = (Employee) clazz.getDeclaredConstructor(new Class[] {String.class,String.class}).newInstance(new Object[] {"a","b"});
        method.invoke(employee, "hello");
        System.out.println(employee.getPassword());
    }
}
