package github.dandeduck.astromech.Positioning;

import github.dandeduck.astromech.units.angle.Angle;
import github.dandeduck.astromech.units.complex.MotionState;

public interface Trackable {
    MotionState motionState();
    Angle angle();
}
