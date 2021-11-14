package github.dandeduck.units.units.complex;

import github.dandeduck.units.units.TimeUnit;
import github.dandeduck.units.units.Unit;

public class AccelerationUnit implements Unit {
    private final VelocityUnit velocityUnit;
    private final TimeUnit timeUnit;

    public AccelerationUnit(VelocityUnit velocityUnit) {
        this(velocityUnit, velocityUnit.timeUnit());
    }

    public AccelerationUnit(VelocityUnit velocityUnit, TimeUnit timeUnit) {
        this.velocityUnit = velocityUnit;
        this.timeUnit = timeUnit;
    }

    public static AccelerationUnit kilometersPerHourSquared() {
        return new AccelerationUnit(VelocityUnit.kilometersPerHour());
    }

    public static AccelerationUnit metersPerSecondSquared() {
        return new AccelerationUnit(VelocityUnit.metersPerSecond());
    }

    public static AccelerationUnit milesPerHourSquared() {
        return new AccelerationUnit(VelocityUnit.milesPerHour());
    }

    public static AccelerationUnit feetPerSecondSquareSquared() {
        return new AccelerationUnit(VelocityUnit.feetPerSecond());
    }

    @Override
    public double toBaseUnitScale() {
        return velocityUnit.toBaseUnitScale()/timeUnit.toBaseUnitScale();
    }

    public VelocityUnit velocityUnit() {
        return velocityUnit;
    }

    public TimeUnit timeUnit() {
        return timeUnit;
    }
}
