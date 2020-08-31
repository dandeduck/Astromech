package github.dandeduck.astromech.Positioning;

import github.dandeduck.astromech.units.complex.MotionState;
import github.dandeduck.astromech.units.morion.Acceleration;
import github.dandeduck.astromech.units.morion.Jerk;
import github.dandeduck.astromech.units.morion.Velocity;

public abstract class BasicTrackable implements Trackable{
    @Override
    public MotionState motionState() {
        return new MotionState(velocity(), acceleration(), jerk());
    }

    public abstract Velocity velocity();
    public abstract Acceleration acceleration();
    public abstract Jerk jerk();
}
