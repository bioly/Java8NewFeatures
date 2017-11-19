package com.lukasz.java8new.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class NashornExample {

    public static void main(String[] args) throws FileNotFoundException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        File f = new File("scripts/readurl.js");
        Reader reader = new FileReader(f);

        String result = null;

        try {
            result = (String)engine.eval(reader);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
