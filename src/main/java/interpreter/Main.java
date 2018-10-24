package interpreter;

public class Main {
    private static Expression buildInterpreterTree(){
        Expression e1 = new TerminalExpress("A");
        Expression e2 = new TerminalExpress("B");
        Expression e3 = new TerminalExpress("C");
        Expression e4 = new TerminalExpress("D");

        //B C
        Expression f1 = new OrExpress(e2,e3);

        //A OR (B C)
        Expression f2 = new OrExpress(e1,f1);

        //D AND (A OR (B C))
        Expression f3 = new AndExpress(e4,f2);
        return f3;
    }


    public static void main(String[] args) {
        Expression expression = buildInterpreterTree();

        String test1 = "D C";

        System.out.println(expression.interpreter(test1));
    }
}
