package io.openexchange.apple.interview.text;

import java.util.function.Consumer;

public final class Feature {

    public static void intersect(Index left, Index right, Consumer<String> c) {
        left.words().parallel().filter(s -> right.count(s) > 0).forEach(c);
    }
}
