package github.dandeduck.units.units;

public enum DistanceUnit implements Unit {
    NANOMETERS(DistanceUnitScale.NANOMETERS_TO_METERS_SCALE),
    MICROMETERS(DistanceUnitScale.MICROMETERS_TO_METERS_SCALE),
    MILLIMETERS(DistanceUnitScale.MILLIMETERS_TO_METERS_SCALE),
    CENTIMETERS(DistanceUnitScale.CENTIMETERS_TO_METERS_SCALE),
    INCHES(DistanceUnitScale.INCHES_TO_METERS_SCALE),
    FEET(DistanceUnitScale.FEET_TO_METERS_SCALE),
    YARDS(DistanceUnitScale.YARDS_TO_METERS_SCALE),
    METERS(1),
    KILOMETERS(GenericUnitScale.KILO_SCALE),
    MILES(DistanceUnitScale.MILES_TO_METERS_SCALE);

    private final double toMetersScale;

    DistanceUnit(double toMetersScale) {
        this.toMetersScale = toMetersScale;
    }

    @Override
    public double toBaseUnitScale() {
        return toMetersScale;
    }
}
