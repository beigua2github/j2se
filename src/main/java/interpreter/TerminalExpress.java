package interpreter;

import java.util.StringTokenizer;

public class TerminalExpress implements Expression {
    private final String literal;

    public TerminalExpress(String literal) {
        this.literal = literal;
    }

    @Override
    public boolean interpreter(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreElements()) {
            String tmp = stringTokenizer.nextToken();
            if (tmp.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
