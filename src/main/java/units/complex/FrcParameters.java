package units.complex;

import units.morion.Acceleration;
import units.morion.Jerk;

public class FrcParameters {
    public static final Acceleration DEFAULT_ACCELERATION_METERS_PER_SECOND_SQUARED = Acceleration.metersPerSecondSquared(2);
    public static final Jerk DEFAULT_JERK_METERS_PER_SECOND_CUBED = Jerk.metersPerSecondCubed(60);
}
