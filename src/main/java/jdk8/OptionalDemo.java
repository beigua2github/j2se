package jdk8;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by beigua on 2017/4/28.
 */
public class OptionalDemo {
    public static void main(String[] args) {

        Test i = new Test();
        System.out.println(Optional
                .ofNullable(i)
                .map(it -> it.getAmount())
                .map(it -> it.intValue())
                .orElse(0));

        Test j = null;
        System.out.println(Optional
                .ofNullable(j)
                .map(it -> it.getAmount())
                .map(it -> it.intValue())
                .orElse(0));

        Test z = new Test();
        z.setAmount(new BigDecimal(1111));
        System.out.println(Optional
                .ofNullable(z)
                .map(it -> it.getAmount())
                .map(it -> it.intValue())
                .orElse(0));
    }
}

@Data
class Test{
    BigDecimal amount;
}
