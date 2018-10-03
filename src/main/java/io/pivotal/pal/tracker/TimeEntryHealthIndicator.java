package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private TimeEntryRepository timeEntriesRepo;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepo) {
        this.timeEntriesRepo = timeEntryRepo;
    }

    @Override
    public Health health() {

        if (timeEntriesRepo.list().size() < 5) {
            return Health.up().build();
        };

        return Health.down().build();
    }
}
