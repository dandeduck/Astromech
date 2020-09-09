package github.dandeduck.units.units;

public interface Unit {
    double toBaseUnitScale();

    default double toUnit(double val, Unit unit) {
        return val * conversionValue(unit);
    }

    default double conversionValue(Unit unit) {
        return toBaseUnitScale()/unit.toBaseUnitScale();
    }
}
