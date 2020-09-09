package github.dandeduck.units.values;

import github.dandeduck.units.units.complex.AccelerationUnit;

public class Acceleration extends ValueBase<AccelerationUnit> {
    public Acceleration(double value, AccelerationUnit unit) {
        super(value, unit);
    }

    public static Acceleration kilometersPerHourSquared(double value) {
        return new Acceleration(value, AccelerationUnit.kilometersPerHourSquared());
    }

    public static Acceleration metersPerSecondSquared(double value) {
        return new Acceleration(value, AccelerationUnit.metersPerSecondSquared());
    }

    public static Acceleration milesPerHourSquared(double value) {
        return new Acceleration(value, AccelerationUnit.milesPerHourSquared());
    }

    public static Acceleration feetPerSecondSquared(double value) {
        return new Acceleration(value, AccelerationUnit.feetPerSecondSquareSquared());
    }

    @Override
    public Acceleration add(Value<AccelerationUnit> other) {
        ValueBase<AccelerationUnit> result = super.add(other);
        return new Acceleration(result.value(), result.unit());
    }

    @Override
    public Acceleration sub(Value<AccelerationUnit> other) {
        ValueBase<AccelerationUnit> result = super.sub(other);
        return new Acceleration(result.value(), result.unit());
    }

    @Override
    public Acceleration mul(double factor) {
        ValueBase<AccelerationUnit> result = super.mul(factor);
        return new Acceleration(result.value(), result.unit());
    }

    @Override
    public Acceleration div(double factor) {
        ValueBase<AccelerationUnit> result = super.div(factor);
        return new Acceleration(result.value(), result.unit());
    }

    public Velocity mul(Time passedTime) {
        return new Velocity(toUnit(new AccelerationUnit(unit().velocityUnit(), passedTime.unit())).value() * passedTime.value(), unit().velocityUnit());
    }

    public double valueAsMetersPerSecondSquared() {
        return toUnit(AccelerationUnit.metersPerSecondSquared()).value();
    }
}
