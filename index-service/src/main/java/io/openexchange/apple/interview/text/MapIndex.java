package io.openexchange.apple.interview.text;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class MapIndex implements Index {

    public final Map<String, Integer> internal = new ConcurrentHashMap<>();

    @Override
    public void add(String word) {
        internal.merge(word, 1, Integer::sum);
    }

    @Override
    public int count(String word) {
        return internal.getOrDefault(word, 0);
    }

    @Override
    public Stream<String> words() {
        return internal.keySet().parallelStream();
    }
}
