package spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.GregorianCalendar;

public class TestSpringSpel {
    public static void main(String[] args) {
        ExpressionParser parser1 = new SpelExpressionParser();
        Expression exp1 = parser1.parseExpression("'Hello World'.bytes.length");
        Integer length = (Integer) exp1.getValue();
        System.out.println(length);

        //  The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", getGregorianCalendar().getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");
        EvaluationContext context = new StandardEvaluationContext(tesla);

        System.out.println((String) exp.getValue(context));
    }

    private static GregorianCalendar getGregorianCalendar() {
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        return c;
    }
}
