package github.dandeduck.units;

import com.flash3388.flashlib.util.CompareResult;
import com.jmath.ExtendedMath;

public interface Value extends Comparable<Value> {
    double value();
    Value add(Value other);
    Value sub(Value other);

    default boolean equals(Value other) {
        return ExtendedMath.equalsExact(sub(other).value(), 0);
    }

    @Override
    default int compareTo(Value other) {
        return (int) ExtendedMath.constrain(sub(other).value(), CompareResult.SMALLER_THAN.value(), CompareResult.GREATER_THAN.value());
    }
}
