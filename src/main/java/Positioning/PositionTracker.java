package Positioning;

import units.complex.Coordinates;

import java.util.concurrent.atomic.AtomicReference;

public class PositionTracker {
    private final Thread trackingThread;
    private final AtomicReference<Coordinates> startingCoordinatesReference;

    public PositionTracker() {
        startingCoordinatesReference = new AtomicReference<>(new Coordinates());
        trackingThread = new Thread(new TrackingRunnable());
    }

    public void start(Coordinates startingCoordinates) {
        reset(startingCoordinates);
        trackingThread.start();
    }

    public void start() {
        trackingThread.start();
    }

    public void reset(Coordinates newCoordinates) {
        startingCoordinatesReference.set(newCoordinates);
    }
}
