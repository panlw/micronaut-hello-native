package xyz.neopan.hello;

import io.micronaut.core.util.StringUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.util.stream.Stream;

/**
 * @author neopan
 * @since 5/13/20
 */
@Controller
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Get("/random")
    public Conference conference() {
        return conferenceService.randomConf();
    }

    @Get("/all")
    public Stream<Conference> conferences(@QueryValue("q") String keyword) {
        return conferenceService.all().stream()
            .filter(x -> StringUtils.isEmpty(keyword)
                || x.getName().contains(keyword));
    }

}
