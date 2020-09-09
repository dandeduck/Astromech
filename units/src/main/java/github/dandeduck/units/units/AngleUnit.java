package github.dandeduck.units.units;

import github.dandeduck.units.units.scales.AngleUnitScale;

public enum AngleUnit implements Unit {
    DEGREES(1),
    RADIANS(AngleUnitScale.RADIAN_TO_DEGREE_SCALE);

    private final double toDegreesScale;

    AngleUnit(double toDegreesScale) {
        this.toDegreesScale = toDegreesScale;
    }

    @Override
    public double toBaseUnitScale() {
        return toDegreesScale;
    }
}
