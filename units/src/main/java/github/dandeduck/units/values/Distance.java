package github.dandeduck.units.values;

import github.dandeduck.units.units.DistanceUnit;

public class Distance extends ValueBase<DistanceUnit> {
    public Distance(double value, DistanceUnit unit) {
        super(value, unit);
    }

    public static Distance kilometers(double value) {
        return new Distance(value, DistanceUnit.KILOMETERS);
    }

    public static Distance meters(double value) {
        return new Distance(value, DistanceUnit.METERS); //inlay hints
    }

    public static Distance centimeters(double value) {
        return new Distance(value, DistanceUnit.CENTIMETERS);
    }

    public static Distance millimeters(double value) {
        return new Distance(value, DistanceUnit.MILLIMETERS);
    }

    public static Distance miles(double value) {
        return new Distance(value, DistanceUnit.MILES);
    }

    public static Distance feet(double value) {
        return new Distance(value, DistanceUnit.FEET);
    }

    public static Distance inches(double value) {
        return new Distance(value, DistanceUnit.INCHES);
    }

    @Override
    public Distance add(Value<DistanceUnit> other) {
        ValueBase<DistanceUnit> result = super.add(other);
        return new Distance(result.value(), result.unit());
    }

    @Override
    public Distance sub(Value<DistanceUnit> other) {
        ValueBase<DistanceUnit> result = super.sub(other);
        return new Distance(result.value(), result.unit());
    }

    @Override
    public Distance mul(double factor) {
        ValueBase<DistanceUnit> result = super.mul(factor);
        return new Distance(result.value(), result.unit());
    }

    @Override
    public Distance div(double factor) {
        ValueBase<DistanceUnit> result = super.div(factor);
        return new Distance(result.value(), result.unit());
    }

    public double valueAsMeters() {
        return toUnit(DistanceUnit.METERS).value();
    }
}
