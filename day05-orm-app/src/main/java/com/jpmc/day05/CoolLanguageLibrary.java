package com.jpmc.day05;

import java.util.*;

public class CoolLanguageLibrary {
//    private List<String> langs
//            = Arrays.asList("Java", "JS", "Python");
    //private Set<String> langs = new HashSet<>();
    private Vector<String> langs = new Vector<>();
    public CoolLanguageLibrary() {
        langs.add("Ruby");
        langs.add("Go");
        langs.add("Java");
    }
    //an abstraction on collections
    //it hides the implementation
    //so the user of this method, need not change
    //if my implementation changes
    public Iterator<String> getLangs() {
        return langs.iterator();
    }
}
