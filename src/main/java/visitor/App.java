package visitor;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        IVisitor zhansan = new StudentVisitor("张三");
        IVisitor lisi = new ManagerVisitor("李四", 0);

        CIIE art = new ArtCIIE("艺术馆", "北欧风格");
        CIIE auto = new AutoCIIE("汽车馆");

        ArrayList<CIIE> ciies = Lists.newArrayList(art, auto);

        ciies.forEach(ciie -> {
            ciie.accept(zhansan);
            ciie.accept(lisi);
        });

        System.out.println(lisi);
    }
}
