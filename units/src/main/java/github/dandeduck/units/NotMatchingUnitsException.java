package github.dandeduck.units;

public class NotMatchingUnitsException extends IllegalArgumentException{
    public NotMatchingUnitsException() {
        super("different github.dandeduck.units cannot be added or subtracted");
    }
}
