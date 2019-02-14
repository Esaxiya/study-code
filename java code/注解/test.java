

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Coder {
    int id();
    String name();
    String language();
    String company();
}



public class test{
    public static void main(String[] args) {
        System.out.println(3&9);    // 0011 & 1001 = 0001   -->1
        System.out.println(3|9);    // 0011 | 1001 = 1011   -->11
    }
}
