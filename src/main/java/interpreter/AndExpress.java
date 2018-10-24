package interpreter;

public class AndExpress implements Expression {
    private Expression one;
    private Expression two;

    public AndExpress(Expression one,Expression two){
        this.one = one;
        this.two = two;
    }


    @Override
    public boolean interpreter(String str) {
        return one.interpreter(str) && two.interpreter(str);
    }
}
