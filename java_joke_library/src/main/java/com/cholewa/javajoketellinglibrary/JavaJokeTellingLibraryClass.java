package com.cholewa.javajoketellinglibrary;

public class JavaJokeTellingLibraryClass {

    private static int jokeIndex = 0;

    public String GetNextJoke(){
        return String.format("Joke number %d", jokeIndex++);
    }
}
