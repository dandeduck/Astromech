package Positioning;

import units.angle.Angle;
import units.complex.MotionState;

public interface Trackable {
    MotionState motionState();
    Angle angle();
}
