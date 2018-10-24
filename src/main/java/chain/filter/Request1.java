package chain.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request1 implements Request {
    private String type;

    @Override
    public String getMessage() {
        return "Hello,world!";
    }
}
