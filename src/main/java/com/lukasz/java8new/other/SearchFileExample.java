package com.lukasz.java8new.other;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public class SearchFileExample {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("data", "hamlet.txt");
        final String searchTerm = "married  with my uncle";

        try(Stream<String> lines = Files.lines(path)) {
            Optional<String> line = lines.filter(l ->
                l.contains(searchTerm)).findFirst();
            if(line.isPresent()){
                System.out.println("Found: " + line);
            } else {
                System.out.println("Not found");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
