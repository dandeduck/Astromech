package github.dandeduck.units.units;

import github.dandeduck.units.units.scales.TimeUnitScale;

public enum TimeUnit implements Unit {
    NANOSECONDS(TimeUnitScale.NANOSECONDS_TO_SECONDS_SCALE),
    MICROSECONDS(TimeUnitScale.MICROSECONDS_TO_SECONDS_SCALE),
    MILLISECONDS(TimeUnitScale.MILLISECONDS_TO_SECONDS_SCALE),
    SECONDS(1),
    MINUTES(TimeUnitScale.MINUTES_TO_SECONDS_SCALE),
    HOURS(TimeUnitScale.HOURS_TO_SECONDS_SCALE),
    DAYS(TimeUnitScale.DAYS_TO_SECONDS_SCALE),
    WEEKS(TimeUnitScale.WEEKS_TO_SECONDS_SCALE);

    private final double toSecondsScale;

    TimeUnit(double toSecondsScale) {
        this.toSecondsScale = toSecondsScale;
    }

    @Override
    public double toBaseUnitScale() {
        return toSecondsScale;
    }
}
