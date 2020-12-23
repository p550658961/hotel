import java.util.Date;

public class OTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}
