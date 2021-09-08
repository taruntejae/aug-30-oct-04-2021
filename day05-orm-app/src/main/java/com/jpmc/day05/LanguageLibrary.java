package com.jpmc.day05;

import java.util.*;

public class LanguageLibrary {
//    private List<String> langs =
//            Arrays.asList("Java", "JS", "Python");
    //private Set<String> langs = new HashSet<>();
    private Vector<String> langs = new Vector();
    public LanguageLibrary() {
        langs.add("Java");
        langs.add("JS");
        langs.add("Python");
    }

    public Vector<String> getLangs() {
        return langs;
    }
}
