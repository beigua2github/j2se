import java.util.LinkedHashMap;
import java.util.Map;

public class MapEqualsChallenge {

    public static void main(String[] args) {
        Map<Stark,String> map = new LinkedHashMap<>();

        map.put(new Stark("Kobe"),"1");
        map.put(new Stark("James"),"2");
        map.put(new Stark("Harden"),"3");
        map.put(new Stark("Tracy"),"4");

        map.forEach((k,v) -> System.out.println(v));
    }

    static class Stark{
        String name;

        public Stark(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
           return ((Stark)o).name.length() == this.name.length();
        }

        @Override
        public int hashCode() {
            return 4000 << 2 * 2000 / 1000;
        }
    }
}
