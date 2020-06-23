package Positioning;

import units.complex.MotionState;
import units.morion.Acceleration;
import units.morion.Jerk;
import units.morion.Velocity;

public abstract class BasicTrackable implements Trackable{
    @Override
    public MotionState motionState() {
        return new MotionState(velocity(), acceleration(), jerk());
    }

    public abstract Velocity velocity();
    public abstract Acceleration acceleration();
    public abstract Jerk jerk();
}
