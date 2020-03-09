package io.openexchange.apple.interview.text;

import junit.framework.TestCase;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class TestMapIndex extends TestCase {

    public void testCreateIndex() {
        var index = new MapIndex();
        asList("xy abc pz xy abc c abc".split("\\s+")).parallelStream().forEach(index::add);

        assertEquals(3, index.count("abc"));
        assertEquals(2, index.count("xy"));
        assertEquals(1, index.count("pz"));
        assertEquals(1, index.count("c"));
        assertEquals(0, index.count("xyi"));
    }

    public void testIndexIntersect() {
        var iLeft = new MapIndex();
        asList("xy abc pz xy abc c abc".split("\\s+")).parallelStream().forEach(iLeft::add);

        var iRight = new MapIndex();
        asList("abc xy abc".split("\\s+")).parallelStream().forEach(iRight::add);

        var intersect = new HashSet<String>();
        Feature.intersect(iLeft, iRight, intersect::add);

        assertTrue(intersect.contains("xy"));
        assertTrue(intersect.contains("abc"));
        assertFalse(intersect.contains("c"));
        assertFalse(intersect.contains("pz"));
        assertFalse(intersect.contains("xyi"));
    }
}
