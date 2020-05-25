/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/21/2020 1:44 PM
 */
package com.slmora.morajavafileaccess.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This Class created for modify all jva base fie read and write actions
 *
 * @Author: SLMORA
 * @DateTime: 5/21/2020 1:44 PM
 * <p>
 * Version      Date            Editor              Note
 * ---------    ----------      ----------------    --------------------------------------------------------------------
 * 1.0          5/21/2020      SLMORA                Initial Code
 */
public class FileAccess {
    /**
     * Test the add() method with input values 1, 2 for expected 3
     * @param filePath as String Object with location of filter file
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file using java 8 Stream
     * */
    public void readFileMode01(String filePath){
        //read file into stream, try-with-resources
        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {

            fileStream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFileMode02(String filePath){
        List<String> list = new ArrayList<>();

        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
//            list = fileStream
//                    .filter(line -> !line.startsWith("line3"))
//                    .map(String::toUpperCase)
//                    .collect(Collectors.toList());

            list = fileStream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }

    public void readFileMode03(String filePath){
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }

    public void readFileMode04(String filePath){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileMode05(String filePath){

        try (Scanner scanner = new Scanner(new File(filePath))) {

            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 *
 */
