package spring;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author beigua
 */
@Data
public class PlayerFactoryBean implements FactoryBean<Player> {
    private String name;
    private int age;
    private Player player;

    public void init() {
        player = new Player();
        player.setAge(this.age);
        player.setName(this.name);
    }

    @Override
    public Player getObject() {
        return this.player;
    }

    @Override
    public Class<?> getObjectType() {
        return player.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
