package visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentVisitor implements IVisitor {
    String name;

    @Override
    public void visit(ArtCIIE ciie) {
        System.out.println(String.format("大学生 %s 参观了 %s", this.name, ciie));
    }

    @Override
    public void visit(AutoCIIE ciie) {
        System.out.println(String.format("大学生 %s 参观了 %s", this.name, ciie));
    }
}
