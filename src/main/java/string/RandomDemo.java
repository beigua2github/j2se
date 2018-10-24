package string;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDemo {
    public static void main(String[] args) {

        System.out.println(ThreadLocalRandom.current().nextInt(4,100));

        System.out.println(GenCaptcha());

        System.out.println((char)0x1A);

        Integer a = new Integer(1);

        System.out.println("1".equals(a.toString()));



    }

    public static String GenCaptcha() {

        char data[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char index[] = new char[6];

        Random r = new Random();
        int i;

        String captcha = "";
        for (i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length);
            index[i] = data[ran];
            captcha = String.valueOf(index);
        }
        return captcha;

    }
}
