package github.dandeduck.units.values;

import github.dandeduck.units.units.TimeUnit;
import github.dandeduck.units.units.complex.VelocityUnit;

public class Velocity extends ValueBase<VelocityUnit> {
    public Velocity(double value, VelocityUnit unit) {
        super(value, unit);
    }

    public static Velocity kilometersPerHour(double value) {
        return new Velocity(value, VelocityUnit.kilometersPerHour());
    }

    public static Velocity metersPerSecond(double value) {
        return new Velocity(value, VelocityUnit.metersPerSecond());
    }

    public static Velocity milesPerHour(double value) {
        return new Velocity(value, VelocityUnit.milesPerHour());
    }

    public static Velocity feetPerSecond(double value) {
        return new Velocity(value, VelocityUnit.feetPerSecond());
    }

    @Override
    public Velocity add(Value<VelocityUnit> other) {
        ValueBase<VelocityUnit> result = super.add(other);
        return new Velocity(result.value(), result.unit());
    }

    @Override
    public Velocity sub(Value<VelocityUnit> other) {
        ValueBase<VelocityUnit> result = super.sub(other);
        return new Velocity(result.value(), result.unit());
    }

    @Override
    public Velocity mul(double factor) {
        ValueBase<VelocityUnit> result = super.mul(factor);
        return new Velocity(result.value(), result.unit());
    }

    @Override
    public Velocity div(double factor) {
        ValueBase<VelocityUnit> result = super.div(factor);
        return new Velocity(result.value(), result.unit());
    }

    public Distance mul(Time passedTime) {
        return new Distance(toUnit(new VelocityUnit(unit().distanceUnit(), passedTime.unit())).value() * passedTime.value(), unit().distanceUnit());
    }

    public double valueAsMetersPerSecond() {
        return toUnit(VelocityUnit.metersPerSecond()).value();
    }
}
