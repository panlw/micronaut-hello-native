package xyz.neopan.hello;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author neopan
 * @since 5/13/20
 */
@Singleton
public class ConferenceService {

    private static final List<Conference> CONFERENCES = Arrays.asList(
        new Conference("Greach"),
        new Conference("GR8Conf EU"),
        new Conference("Micronaut Summit"),
        new Conference("Devoxx Belgium"),
        new Conference("Oracle Code One"),
        new Conference("CommitConf"),
        new Conference("Codemotion Madrid")
    );

    public Conference randomConf() {
        return CONFERENCES.get(new Random().nextInt(CONFERENCES.size()));
    }

    public List<Conference> all() {
        return Collections.unmodifiableList(CONFERENCES);
    }

}
