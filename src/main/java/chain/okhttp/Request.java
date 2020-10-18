package chain.okhttp;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private List<String> instances;

    public Request() {
        this.instances = new ArrayList<>();
    }

    public List<String> getInstances() {
        return instances;
    }

    public void addOne(String instance) {
        this.instances.add(instance);
    }
}
