import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.jupiter.api.Test;

public class CglibDemo {

    @Test
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Sample.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib!";
            }
        });
        Sample proxy = (Sample) enhancer.create();
        assert "Hello cglib!".equals(proxy.test(null));
    }
}
