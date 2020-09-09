package github.dandeduck.units.morion;

import github.dandeduck.units.distance.DistanceUnit;
import github.dandeduck.units.NotMatchingUnitsException;
import github.dandeduck.units.Value;
import github.dandeduck.units.mass.MassUnit;
import github.dandeduck.units.time.TimeUnit;

public class Force implements Value {
    private final double value;
    private final MassUnit massUnit;
    private final DistanceUnit distanceUnit;
    private final TimeUnit firstTimeUnit;
    private final TimeUnit secondTimeUnit;

    public Force(double value, MassUnit massUnit, DistanceUnit distanceUnit, TimeUnit firstTimeUnit, TimeUnit secondTimeUnit) {
        this.value = value;
        this.massUnit = massUnit;
        this.distanceUnit = distanceUnit;
        this.firstTimeUnit = firstTimeUnit;
        this.secondTimeUnit = secondTimeUnit;
    }

    public static Force newtons(double value) {
        return new Force(value, MassUnit.KILOGRAMS, DistanceUnit.METERS, TimeUnit.SECONDS, TimeUnit.SECONDS);
    }

    public static Force poundsForce(double value) {
        return new Force(value, MassUnit.POUNDS, DistanceUnit.FEET, TimeUnit.SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public Value add(Value other) {
        if (other instanceof Force)
            return add((Force) other);
        else
            throw new NotMatchingUnitsException();
    }

    @Override
    public Force sub(Value other) {
        if (other instanceof Force)
            return sub((Force) other);
        else
            throw new NotMatchingUnitsException();
    }

    public Force add(Force other) {
        other = other.toUnit(this);
        return new Force(value + other.value(), massUnit, distanceUnit, firstTimeUnit, secondTimeUnit);
    }

    public Force sub(Force other) {
        other = other.toUnit(this);
        return new Force(value - other.value(), massUnit, distanceUnit, firstTimeUnit, secondTimeUnit);
    }

    public double valueAsNewtons() {
        return toUnit(MassUnit.KILOGRAMS, DistanceUnit.METERS, TimeUnit.SECONDS, TimeUnit.SECONDS).value();
    }

    public double div(Force other) {
        other = other.toUnit(this);
        return value()/other.value();
    }


    public Force div(double denominator) {
        return new Force(value/denominator, massUnit, distanceUnit, firstTimeUnit, secondTimeUnit);
    }

    public Force mul(double scalar) {
        return new Force(value*scalar, massUnit, distanceUnit, firstTimeUnit, secondTimeUnit);
    }

    public Force toUnit(Force other) {
        return toUnit(other.massUnit, other.distanceUnit, other.firstTimeUnit, other.secondTimeUnit);
    }

    public Force toUnit(MassUnit newMassUnit, DistanceUnit newDistanceUnit, TimeUnit newFirstTimeUnit, TimeUnit newSecondTimeUnit) {
        return new Force(
                massUnit.toUnit(newMassUnit,
                        distanceUnit.toUnit(newDistanceUnit,
                                firstTimeUnit.toUnit(newFirstTimeUnit,
                                        secondTimeUnit.toUnit(newSecondTimeUnit, value)))), newMassUnit, newDistanceUnit, newFirstTimeUnit, newSecondTimeUnit);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Force && equals((Force) o);
    }

    @Override
    public String toString() {
        return String.format("%.4f [%s] by [%s] per [%s] per [%s]", value, massUnit.name(), distanceUnit.name(), firstTimeUnit.name(), secondTimeUnit.name());
    }
}
