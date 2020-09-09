package github.dandeduck.units.values;

import github.dandeduck.units.units.AngleUnit;

public class Angle extends ValueBase<AngleUnit> {
    public Angle(double value, AngleUnit unit) {
        super(value, unit);
    }

    public static Angle degrees(double value) {
        return new Angle(value, AngleUnit.DEGREES);
    }

    public static Angle radians(double value) {
        return new Angle(value, AngleUnit.RADIANS);
    }

    @Override
    public Angle add(Value<AngleUnit> other) {
        ValueBase<AngleUnit> result = super.add(other);
        return new Angle(result.value(), result.unit());
    }

    @Override
    public Angle sub(Value<AngleUnit> other) {
        ValueBase<AngleUnit> result = super.sub(other);
        return new Angle(result.value(), result.unit());
    }

    @Override
    public Angle mul(double factor) {
        ValueBase<AngleUnit> result = super.mul(factor);
        return new Angle(result.value(), result.unit());
    }

    @Override
    public Angle div(double factor) {
        ValueBase<AngleUnit> result = super.div(factor);
        return new Angle(result.value(), result.unit());
    }

    public double valueAsDegrees() {
        return toUnit(AngleUnit.DEGREES).value();
    }

    public double valueAsRadians() {
        return toUnit(AngleUnit.RADIANS).value();
    }
}
