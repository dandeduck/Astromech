package github.dandeduck.units;

public interface Unit {
    double toBaseUnitScale();

    default double toUnit(Unit unit, double val) {
        return val * conversionValue(unit);
    }

    default double conversionValue(Unit unit) {
        return toBaseUnitScale()/unit.toBaseUnitScale();
    }
}
