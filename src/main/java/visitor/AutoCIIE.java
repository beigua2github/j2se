package visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * 汽车馆
 * @author beigua
 */
@Data
@AllArgsConstructor
public class AutoCIIE implements CIIE {
    String name;

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
