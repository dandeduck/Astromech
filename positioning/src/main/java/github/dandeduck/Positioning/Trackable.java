package github.dandeduck.Positioning;

import github.dandeduck.units.complex.MotionState;
import github.dandeduck.units.values.Angle;

public interface Trackable {
    MotionState motionState();
    Angle angle();
}
