package github.dandeduck.units.values;

import github.dandeduck.units.units.complex.JerkUnit;

public class Jerk extends ValueBase<JerkUnit> {
    public Jerk(double value, JerkUnit unit) {
        super(value, unit);
    }

    public static Jerk kilometersPerHourCubed(double value) {
        return new Jerk(value, JerkUnit.kilometersPerHourCubed());
    }

    public static Jerk metersPerSecondCubed(double value) {
        return new Jerk(value, JerkUnit.metersPerSecondCubed());
    }

    public static Jerk milesPerHourCubed(double value) {
        return new Jerk(value, JerkUnit.milesPerHourCubed());
    }

    public static Jerk feetPerSecondCubed(double value) {
        return new Jerk(value, JerkUnit.feetPerSecondCubed());
    }

    @Override
    public Jerk add(Value<JerkUnit> other) {
        ValueBase<JerkUnit> result = super.add(other);
        return new Jerk(result.value(), result.unit());
    }

    @Override
    public Jerk sub(Value<JerkUnit> other) {
        ValueBase<JerkUnit> result = super.sub(other);
        return new Jerk(result.value(), result.unit());
    }

    @Override
    public Jerk mul(double factor) {
        ValueBase<JerkUnit> result = super.mul(factor);
        return new Jerk(result.value(), result.unit());
    }

    @Override
    public Jerk div(double factor) {
        ValueBase<JerkUnit> result = super.div(factor);
        return new Jerk(result.value(), result.unit());
    }

    public Acceleration mul(Time passedTime) {
        return new Acceleration(toUnit(new JerkUnit(unit().accelerationUnit(), passedTime.unit())).value() * passedTime.value(), unit().accelerationUnit());
    }

    public double valueAsMetersPerSecondCubed() {
        return toUnit(JerkUnit.metersPerSecondCubed()).value();
    }
}
