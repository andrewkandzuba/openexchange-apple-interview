package io.openexchange.apple.interview.text;

import java.util.stream.Stream;

public interface Index {
    void add(String word);
    int count(String word);
    Stream<String> words();
}
