package visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 场馆管理员
 * @author beigua
 */
@Data
@AllArgsConstructor
public class ManagerVisitor implements IVisitor {
    String name;
    int count;

    @Override
    public void visit(ArtCIIE ciie) {
        count ++;
    }

    @Override
    public void visit(AutoCIIE ciie) {
        count ++;
    }

    @Override
    public String toString() {
        return name + "负责管理" + count + "个场馆.";
    }
}
