import tp1.MotCles;

public class Main {

    public static void main(String[] args) {
        MotCles m = new MotCles();
        boolean test = m.keyword("bonjour", "Je suis bonj , ca va ! bonjour ");
        System.out.println(test);
    }
}