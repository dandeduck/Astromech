package github.dandeduck.units.units.complex;

import github.dandeduck.units.units.DistanceUnit;
import github.dandeduck.units.units.TimeUnit;
import github.dandeduck.units.units.Unit;

public class VelocityUnit implements Unit {
    private final DistanceUnit distanceUnit;
    private final TimeUnit timeUnit;

    public VelocityUnit(DistanceUnit distanceUnit, TimeUnit timeUnit) {
        this.distanceUnit = distanceUnit;
        this.timeUnit = timeUnit;
    }

    public static VelocityUnit kilometersPerHour() {
        return new VelocityUnit(DistanceUnit.KILOMETERS, TimeUnit.HOURS);
    }

    public static VelocityUnit metersPerSecond() {
        return new VelocityUnit(DistanceUnit.METERS, TimeUnit.SECONDS);
    }

    public static VelocityUnit milesPerHour() {
        return new VelocityUnit(DistanceUnit.MILES, TimeUnit.HOURS);
    }

    public static VelocityUnit feetPerSecond() {
        return new VelocityUnit(DistanceUnit.FEET, TimeUnit.SECONDS);
    }

    @Override
    public double toBaseUnitScale() {
        return distanceUnit.toBaseUnitScale()/timeUnit.toBaseUnitScale();
    }

    public DistanceUnit distanceUnit() {
        return distanceUnit;
    }

    public TimeUnit timeUnit() {
        return timeUnit;
    }
}
