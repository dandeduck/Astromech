package units.generic;

import com.flash3388.flashlib.util.CompareResult;
import com.jmath.ExtendedMath;

public interface Value extends Comparable<Value> {
    double DEF_DELTA = 0.001;

    double value();
    Value add(Value other);
    Value sub(Value other);

    default boolean equals(Value other) {
        return ExtendedMath.equals(sub(other).value(), 0, DEF_DELTA);
    }

    @Override
    default int compareTo(Value other) {
        return (int) ExtendedMath.constrain(sub(other).value(), CompareResult.SMALLER_THAN.value(), CompareResult.GREATER_THAN.value());
    }
}
