/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/21/2020 1:44 PM
 */
package com.slmora.morajavafileaccess;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
public class FileAccess
{
    final static Logger LOGGER = LogManager.getLogger(FileAccess.class);

    public void loggerTest()
    {
        LOGGER.info("The main() method is called");
        LOGGER.warn("Warning message");
        LOGGER.error("Error message");
    }

    /**
     * Console print full content of given file
     *
     * @param filePath as String Object with location of filter file
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Print full content of given file by reading using Stream
     */
    public void printFileFullContentToListUsingStream(String filePath)
    {
        //read file into stream, try-with-resources
        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
    }

    /**
     * Read file in given path and return it with List object
     *
     * @param filePath as String Object with location of filter file
     * @return List<String> Object will return with file content
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file and collect full content in to list using Stream
     */
    public List getFileFullContentToListUsingStream(String filePath)
    {
        List<String> list = new ArrayList<>();
        //read file into stream, try-with-resources
        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {
            list = fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }finally {
            return list;
        }
    }

    /**
     * Read file in given path and return filtered out put in to List object
     * Filter each line not starts with given startsWith value
     * Map value 10 with given numberReplace value with 4 leftpad
     * Map all Characters in to UpperCase
     *
     * @param filePath for resource file, startsWith filter lines, numberReplace for replacing number as String Objects
     * @return List<String> Object will return with file content
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file and collect full content in to list using Stream
     */
    public List getFilteredFileContentToListUsingStream(String filePath, String startsWith, String numberReplace)
    {
        List<String> list = new ArrayList<>();
        //read file into stream, try-with-resources
        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {
            list = fileStream
                    .filter(line -> !line.startsWith(startsWith))
                    .map(line -> line.replaceAll("10", StringUtils.leftPad(numberReplace, 4, "0")))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }finally {
            return list;
        }
    }

    /**
     * Read file in given path and return it with List object
     *
     * @param filePath as String Object with location of filter file
     * @return List<String> Object will return with file content
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file and collect full content in to list using Stream
     */
    public List getFileFullContentToListUsingBufferedReader(String filePath)
    {
        List<String> list = new ArrayList<>();
        //read file into BufferedReader, try-with-resources
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }finally {
            return list;
        }
    }

    /**
     * Read file in given path and return filtered out put in to List object
     * Filter each line not starts with given startsWith value
     * Map value 10 with given numberReplace value with 4 leftpad
     * Map all Characters in to UpperCase
     *
     * @param filePath for resource file, startsWith filter lines, numberReplace for replacing number as String Objects
     * @return List<String> Object will return with file content
     * @throws IOException with file notfound aor compatibility issue
     * @apiNote Read file and collect full content in to list using Stream
     */
    public List getFilteredFileContentToListUsingBufferedReader(String filePath, String startsWith, String numberReplace)
    {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if(!line.startsWith(startsWith)){
                    if(line.contains("10")){
                        line = line.replaceAll("10", StringUtils.leftPad(numberReplace, 4, "0"));
                    }
                    line = line.toUpperCase();
                    list.add(line);
                }
            }
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public void readFileMode05(String filePath)
    {

        try (Scanner scanner = new Scanner(new File(filePath))) {

            while (scanner.hasNext()) {
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
