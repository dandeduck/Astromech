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
        other = new ValueBase<>(other.unit().toUnit(other.value(), unit), unit);
        return new ValueBase<>(value + other.value(), unit);
    }

    @Override
    public ValueBase<U> sub(Value<U> other) {
        other = new ValueBase<>(other.unit().toUnit(other.value(), unit), unit);
        return new ValueBase<>(value - other.value(), unit);
    }

    public ValueBase<U> toUnit(U newUnit) {
        return new ValueBase<>(unit.toUnit(value, newUnit), newUnit);
    }
}
