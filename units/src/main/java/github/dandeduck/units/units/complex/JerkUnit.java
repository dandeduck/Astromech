package github.dandeduck.units.units.complex;

import github.dandeduck.units.units.TimeUnit;
import github.dandeduck.units.units.Unit;

public class JerkUnit implements Unit {
    private final AccelerationUnit accelerationUnit;
    private final TimeUnit timeUnit;

    public JerkUnit(AccelerationUnit accelerationUnit) {
        this(accelerationUnit, accelerationUnit.timeUnit());
    }

    public JerkUnit(AccelerationUnit accelerationUnit, TimeUnit timeUnit) {
        this.accelerationUnit = accelerationUnit;
        this.timeUnit = timeUnit;
    }

    public static JerkUnit kilometersPerHourCubed() {
        return new JerkUnit(AccelerationUnit.kilometersPerHourSquared());
    }

    public static JerkUnit metersPerSecondCubed() {
        return new JerkUnit(AccelerationUnit.metersPerSecondSquared());
    }

    public static JerkUnit milesPerHourCubed() {
        return new JerkUnit(AccelerationUnit.milesPerHourSquared());
    }

    public static JerkUnit feetPerSecondCubed() {
        return new JerkUnit(AccelerationUnit.feetPerSecondSquareSquared());
    }

    @Override
    public double toBaseUnitScale() {
        return accelerationUnit.toBaseUnitScale()/timeUnit.toBaseUnitScale();
    }

    public AccelerationUnit accelerationUnit() {
        return accelerationUnit;
    }

    public TimeUnit timeUnit() {
        return timeUnit;
    }
}
