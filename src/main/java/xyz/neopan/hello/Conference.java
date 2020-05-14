package xyz.neopan.hello;

import io.micronaut.core.annotation.Introspected;

/**
 * @author neopan
 * @since 5/13/20
 */
@Introspected
public class Conference {

    private String name;

    public Conference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
