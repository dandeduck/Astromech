package Positioning;

import com.flash3388.flashlib.robot.scheduling.actions.Action;
import com.flash3388.flashlib.time.Clock;
import units.angle.Angle;
import units.complex.Coordinates;
import units.complex.MotionState;
import units.distance.Distance;
import units.time.Time;

import java.util.function.Supplier;

public class TrackingAction extends Action {
    private final Clock clock;
    private final Supplier<MotionState> stateSupplier;
    private final Supplier<Angle> angleSupplier;

    private Time lastTime;
    private Coordinates currentCoordinates;

    public TrackingAction(Clock clock, Supplier<MotionState> stateSupplier, Supplier<Angle> angleSupplier) {
        this(new Coordinates(), clock, stateSupplier, angleSupplier);
    }

    public TrackingAction(Coordinates startCoordinates, Clock clock, Supplier<MotionState> stateSupplier, Supplier<Angle> angleSupplier) {
        this.clock = clock;
        this.currentCoordinates = startCoordinates;
        this.stateSupplier = stateSupplier;
        this.angleSupplier = angleSupplier;
    }

    public void reset(Coordinates newCoordinates) {
        currentCoordinates = newCoordinates;
    }

    public Coordinates currentCoordinates() {
        return currentCoordinates;
    }

    @Override
    protected void execute() {
        lastTime = Time.fromFlashTime(clock.currentTime());
        MotionState sumState = stateSupplier.get();
        Angle angle = angleSupplier.get();
        updateX(sumState, angle);
        updateY(sumState, angle);
    }

    @Override
    protected void end() {
    }

    private void updateX(MotionState sumState, Angle angle) {
        currentCoordinates = currentCoordinates.shiftX(changeInCoordinate(xState(sumState, angle)));
    }

    private void updateY(MotionState sumState, Angle angle) {
        currentCoordinates = currentCoordinates.shiftY(changeInCoordinate(yState(sumState, angle)));
    }

    private MotionState xState(MotionState sumState, Angle angle) {
        return null;
    }

    private MotionState yState(MotionState sumState, Angle angle) {
        return null;
    }

    private Distance changeInCoordinate(MotionState state) {
        return null;
    }

    private double deltaTimeSeconds() {
        return Time.fromFlashTime(clock.currentTime()).sub(lastTime).valueAsSeconds();
    }
}
