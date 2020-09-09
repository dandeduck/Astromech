package github.dandeduck.units.values;

import github.dandeduck.units.units.TimeUnit;

public class Time extends ValueBase<TimeUnit> {
    public Time(double value, TimeUnit unit) {
        super(value, unit);
    }

    public static Time hours(double value) {
        return new Time(value, TimeUnit.HOURS);
    }

    public static Time minutes(double value) {
        return new Time(value, TimeUnit.MINUTES);
    }

    public static Time seconds(double value) {
        return new Time(value, TimeUnit.SECONDS);
    }

    public static Time milliseconds(double value) {
        return new Time(value, TimeUnit.MILLISECONDS);
    }

    @Override
    public Time add(Value<TimeUnit> other) {
        ValueBase<TimeUnit> result = super.add(other);
        return new Time(result.value(), result.unit());
    }

    @Override
    public Time sub(Value<TimeUnit> other) {
        ValueBase<TimeUnit> result = super.sub(other);
        return new Time(result.value(), result.unit());
    }

    @Override
    public Time mul(double factor) {
        ValueBase<TimeUnit> result = super.mul(factor);
        return new Time(result.value(), result.unit());
    }

    @Override
    public Time div(double factor) {
        ValueBase<TimeUnit> result = super.div(factor);
        return new Time(result.value(), result.unit());
    }

    public double valueAsSeconds() {
        return toUnit(TimeUnit.SECONDS).value();
    }

    public double valueAsMilliseconds() {
        return toUnit(TimeUnit.MILLISECONDS).value();
    }
}
