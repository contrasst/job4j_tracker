package checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    private String surname;
    private String name;
    public static final String NEWVALUE = "Broken";

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f) {

    }

}
