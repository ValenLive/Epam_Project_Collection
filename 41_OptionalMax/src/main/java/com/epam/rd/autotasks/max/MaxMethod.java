package com.epam.rd.autotasks.max;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if (values == null || values.length == 0) return OptionalInt.empty();
        return OptionalInt.of(Arrays.stream(values).max().getAsInt());
    }
}
