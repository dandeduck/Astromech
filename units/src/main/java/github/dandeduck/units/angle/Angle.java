package github.dandeduck.units.angle;

import github.dandeduck.units.NotMatchingUnitsException;
import github.dandeduck.units.Value;

public class Angle implements Value {
    private final double value;
    private final AngleUnit unit;

    public Angle(double value, AngleUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Angle degrees(double value) {
        return new Angle(value, AngleUnit.DEGREES);
    }

    public static Angle radians(double value) {
        return new Angle(value, AngleUnit.RADIANS);
    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public Angle add(Value other) {
        if (other instanceof Angle)
            return add((Angle)other);
        else
            throw new NotMatchingUnitsException();
    }

    @Override
    public Value sub(Value other) {
        if (other instanceof Angle)
            return sub((Angle)other);
        else
            throw new NotMatchingUnitsException();
    }

    public AngleUnit unit() {
        return unit;
    }

    public double valueAsDegrees() {
        return unit.toUnit(AngleUnit.DEGREES, value);
    }

    public double valueAsRadians() {
        return unit.toUnit(AngleUnit.RADIANS, value);
    }

    public Angle add(Angle other) {
        other = other.toUnit(unit);
        return new Angle(value + other.value(), unit);
    }

    public Angle sub(Angle other) {
        other = other.toUnit(unit);
        return new Angle(value - other.value(), unit);
    }

    public double div(Angle other) {
        other = other.toUnit(unit);
        return value / other.value();
    }

    public Angle div(double denominator) {
        return new Angle(value / denominator, unit);
    }

    public Angle mul(double scalar) {
        return new Angle(value * scalar, unit);
    }

    public Angle toUnit(AngleUnit newUnit) {
        return new Angle(unit.toUnit(newUnit, value), newUnit);
    }
}
