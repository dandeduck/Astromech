package github.dandeduck.Positioning;

import github.dandeduck.units.complex.MotionState;

public abstract class BasicTrackable implements Trackable{
    @Override
    public MotionState motionState() {
        return new MotionState(velocity(), acceleration(), jerk());
    }

    public abstract Velocity velocity();
    public abstract Acceleration acceleration();
    public abstract Jerk jerk();
}
