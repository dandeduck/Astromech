package github.dandeduck.units.values;

import github.dandeduck.units.units.Unit;

public class ValueBase<U extends Unit> implements Value<U> {
    private final double value;
    private final U unit;

    public ValueBase(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public U unit() {
        return unit;
    }

    @Override
    public ValueBase<U> add(Value<U> other) {
        other = transform(other);
        return new ValueBase<>(value + other.value(), unit);
    }

    @Override
    public ValueBase<U> sub(Value<U> other) {
        other = transform(other);
        return new ValueBase<>(value - other.value(), unit);
    }

    public ValueBase<U> mul(double factor) {
        return new ValueBase<>(value * factor, unit);
    }

    public ValueBase<U> div(double factor) {
        return new ValueBase<>(value / factor, unit);
    }

    public ValueBase<U> toUnit(U newUnit) {
        return new ValueBase<>(unit.toUnit(value, newUnit), newUnit);
    }

    private ValueBase<U> transform(Value<U> other) {
        return new ValueBase<>(other.unit().toUnit(other.value(), unit), unit);
    }
}
