package interpreter;

public class OrExpress implements Expression {
    private Expression one;
    private Expression two;

    public OrExpress(Expression one, Expression two){
        this.one = one;
        this.two = two;
    }


    @Override
    public boolean interpreter(String str) {
        return one.interpreter(str) || two.interpreter(str);
    }
}
