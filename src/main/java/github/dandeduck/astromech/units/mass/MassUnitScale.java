package github.dandeduck.astromech.units.mass;

import static github.dandeduck.astromech.units.generic.GenericUnitScale.KILO_SCALE;

public class MassUnitScale {
    public static final double MILLIGRAM_TO_KILOGRAM_SCALE = 1.0 / (KILO_SCALE * KILO_SCALE);
    public static final double GRAM_TO_KILOGRAM_SCALE = 1.0 / KILO_SCALE;

    public static final double POUND_TO_KILOGRAM_SCALE = 0.453592;
    public static final double OUNCE_TO_KILOGRAM_SCALE = POUND_TO_KILOGRAM_SCALE / 16;
    public static final double SHORT_POUND_TO_KILOGRAM_SCALE = POUND_TO_KILOGRAM_SCALE * 2000;
}
