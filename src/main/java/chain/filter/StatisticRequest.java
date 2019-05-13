package chain.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StatisticRequest implements Request {
    private String type;

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getMessage() {
        return "How many animals are there in the zoo?";
    }
}
