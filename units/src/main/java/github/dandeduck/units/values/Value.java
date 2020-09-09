package github.dandeduck.units.values;

import com.flash3388.flashlib.util.CompareResult;
import com.jmath.ExtendedMath;
import github.dandeduck.units.units.Unit;

public interface Value<U extends Unit> extends Comparable<Value<U>> {
    double value();
    U unit();
    Value<U> add(Value<U> other);
    Value<U> sub(Value<U> other);

    default boolean equals(Value<U> other) {
        return ExtendedMath.equalsExact(sub(other).value(), 0);
    }

    @Override
    default int compareTo(Value<U> other) {
        return (int) ExtendedMath.constrain(sub(other).value(), CompareResult.SMALLER_THAN.value(), CompareResult.GREATER_THAN.value());
    }
}
