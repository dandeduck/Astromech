package github.dandeduck.astromech.units.exceptions;

public class NotMatchingUnitsException extends IllegalArgumentException{
    public NotMatchingUnitsException() {
        super("different github.dandeduck.astromech.units cannot be added or subtracted");
    }
}
