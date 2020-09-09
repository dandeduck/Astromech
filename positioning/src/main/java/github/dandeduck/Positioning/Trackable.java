package github.dandeduck.Positioning;

import github.dandeduck.units.angle.Angle;
import github.dandeduck.units.complex.MotionState;

public interface Trackable {
    MotionState motionState();
    Angle angle();
}
