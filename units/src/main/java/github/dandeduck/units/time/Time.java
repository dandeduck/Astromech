package github.dandeduck.units.time;

import github.dandeduck.units.NotMatchingUnitsException;
import github.dandeduck.units.Value;

public class Time implements Value {
    private final double value;
    private final TimeUnit unit;

    public Time(double value, TimeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Time fromFlashTime(com.flash3388.flashlib.time.Time time) {
        return nanoSeconds(time.toUnit(java.util.concurrent.TimeUnit.NANOSECONDS).value());
    }

    public static Time nanoSeconds(double value) {
        return new Time(value, TimeUnit.NANOSECONDS);
    }

    public static Time milliSeconds(double value) {
        return new Time(value, TimeUnit.MILLISECONDS);
    }

    public static Time seconds(double value) {
        return new Time(value, TimeUnit.SECONDS);
    }

    public static Time minutes(double value) {
        return new Time(value, TimeUnit.MINUTES);
    }

    public static Time hours(double value) {
        return new Time(value, TimeUnit.HOURS);
    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public Time add(Value other) {
        if (other instanceof Time)
            return add((Time)other);
        else
            throw new NotMatchingUnitsException();
    }

    @Override
    public Time sub(Value other) {
        if (other instanceof Time)
            return sub((Time)other);
        else
            throw new NotMatchingUnitsException();
    }

    public TimeUnit unit() {
        return unit;
    }

    public Time add(Time other) {
        other = other.toUnit(unit);
        return new Time(value + other.value(), unit);
    }

    public Time sub(Time other) {
        other = other.toUnit(unit);
        return new Time(value - other.value(), unit);
    }

    public double valueAsSeconds() {
        return unit.toUnit(TimeUnit.SECONDS, value);
    }

    public double valueAsMilliSeconds() {
        return unit.toUnit(TimeUnit.MILLISECONDS, value);
    }

    public double div(Time other) {
        other = other.toUnit(unit);
        return value / other.value();
    }

    public Time div(double denominator) {
        return new Time(value / denominator, unit);
    }

    public Time mul(double scalar) {
        return new Time(value * scalar, unit);
    }

    public Time toUnit(TimeUnit newUnit) {
        return new Time(unit.toUnit(newUnit, value), newUnit);
    }
}
