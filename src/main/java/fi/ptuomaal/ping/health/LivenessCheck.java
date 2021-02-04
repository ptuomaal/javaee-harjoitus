package fi.ptuomaal.ping.health;

import fi.ptuomaal.ping.service.PongService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Liveness
@ApplicationScoped
public class LivenessCheck implements HealthCheck {

    @Inject
    PongService pongService;

    @Override
    public HealthCheckResponse call() {
        return pongService.testDbOperations()
                ? HealthCheckResponse.
                    named("Ping").
                    up().
                    withData("Tietokanta toiminnassa", "Kyllä").
                    build()
                : HealthCheckResponse.
                    named("Ping").
                    down().
                    withData("Tietokanta toiminnassa", "Ei").
                    build();
    }
}
