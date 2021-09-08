package com.jpmc.day05;

import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        CoolLanguageLibrary lib = new CoolLanguageLibrary();
        Iterator<String> langsItr = lib.getLangs();
        while(langsItr.hasNext()){
            String lang = langsItr.next();
            System.out.println(lang);
        }

        //LanguageLibrary lib = new LanguageLibrary();
        //List<String> langs = lib.getLangs();
        //Set<String> langs = lib.getLangs();
//        Vector<String> langs = lib.getLangs();
//        for (String lang: langs) {
//            System.out.println(lang);
//        }

//        List<String> langs = Arrays.asList("Java", "JS", "Python");
//        for (String lang: langs) {
//            System.out.println(lang);
//        }
//
//        Iterator<String> langsItr = langs.iterator();
//        while(langsItr.hasNext()){
//            String lang = langsItr.next();
//            System.out.println(lang);
//        }
    }
}
