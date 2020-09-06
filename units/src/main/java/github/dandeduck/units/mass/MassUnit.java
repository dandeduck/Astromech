package github.dandeduck.units.mass;

import github.dandeduck.units.generic.GenericUnitScale;

public enum MassUnit {
    MILLIGRAMS(MassUnitScale.MILLIGRAM_TO_KILOGRAM_SCALE),
    GRAMS(MassUnitScale.GRAM_TO_KILOGRAM_SCALE),
    KILOGRAMS(1),
    TONNES(GenericUnitScale.KILO_SCALE),
    OUNCES(MassUnitScale.OUNCE_TO_KILOGRAM_SCALE),
    POUNDS(MassUnitScale.POUND_TO_KILOGRAM_SCALE),
    SHORT_TONS(MassUnitScale.SHORT_POUND_TO_KILOGRAM_SCALE);

    private final double toKilogramsScale;

    MassUnit(double toKilogramsScale) {
        this.toKilogramsScale = toKilogramsScale;
    }

    public double toUnit(MassUnit unit, double val) {
        return val * conversionValue(unit);
    }

    private double conversionValue(MassUnit unit) {
        return toKilogramsScale/unit.toKilogramsScale;
    }
}
