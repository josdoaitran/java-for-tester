package annotationtt;

import java.lang.reflect.Method;

public class MainMyAnnotation {

    @MyAnnotation(value = 99)
    public void sayHello(){
        System.out.println("my custom annotation");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MainMyAnnotation myAnnotation = new MainMyAnnotation();
        Method method = myAnnotation.getClass().getMethod("sayHello");

        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        System.out.println("Value is: " + annotation.value()); // Value is: 99
        System.out.println(method.getName());  // SayHello
        myAnnotation.sayHello(); // my custom annotation
    }
}
