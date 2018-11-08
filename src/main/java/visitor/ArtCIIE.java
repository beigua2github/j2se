package visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * 艺术馆
 * @author beigua
 */
@Data
@AllArgsConstructor
public class ArtCIIE implements CIIE{
    private String name;
    private String style;


    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

    @Override
    public String toString() {
        return this.style.concat("的").concat(this.name);
    }
}
