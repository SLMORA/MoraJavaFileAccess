/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/25/2020 6:17 PM
 */
package com.slmora.morajavafileaccess;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This Test Class created for testing com.slmora.morajavafileaccess.FileAccess
 *
 * @Author: SLMORA
 * @DateTime: 5/25/2020 6:17 PM
 * <p>
 * Version      Date            Editor              Note
 * ---------    ----------      ----------------    --------------------------------------------------------------------
 * 1.0          5/25/2020      SLMORA                Initial Code
 */
@DisplayName("Testing com.slmora.morajavafileaccess.FileAccess")
public class FileAccessTest
{
    TestInfo testInfo;
    TestReporter testReporter;
    final static Logger LOGGER = LogManager.getLogger(FileAccess.class);

    Path TEST_FILE_PATH;

    /**
     * Runs this method before initialize this test class
     * */
    @BeforeAll
    public static void beforeAllInit()
    {
        System.out.println("Before all initialized .......");
    }

    /**
     * Runs this method before each test execution
     * @param testInfo, testReporter to inject reporting information
     * */
    @BeforeEach
    public void beforeEachInit(TestInfo testInfo, TestReporter testReporter)
    {
        this.testInfo =  testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags());

        this.TEST_FILE_PATH = Paths.get("D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraJavaFileAccess\\MOD1.txt");

    }

    /**
     * Runs this method after each test execution
     * */
    @AfterEach
    private void afterEachEnd()
    {
        System.out.println("Test Completed "+testInfo.getDisplayName());
        System.out.println("After Each Clean Test........");
    }

    /**
     * This method runs After all Test Cases execution
     * This must be static because of this will execute after instance destroyed
     * */
    @AfterAll
    public static void AfterAllInit()
    {
        System.out.println("After All Initiated........");
    }

    /**
     * This method runs After all Test Cases execution
     * This must be static because of this will execute after instance destroyed
     * */
    @Test
    @DisplayName("Test PrintWriter.close() option to clear the file")
//    @EnabledOnJre(JRE.JAVA_14)
    public void testPrintWriterClose(){
        List<String> list = new ArrayList<>();
        String s = null;
        try (Stream<String> fileStream = Files.lines(TEST_FILE_PATH)){
            new PrintWriter("D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraJavaFileAccess\\MOD1.txt").close();
            list = fileStream.collect(Collectors.toList());
            assertEquals(0,list.size());
        } catch (FileNotFoundException e) {
            LOGGER.error(ExceptionUtils.getMessage(e));
            System.out.println("TTS : "+ExceptionUtils.getMessage(e));
            fail(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            System.out.println("TTS : "+ExceptionUtils.getFullStackTrace(e));
            fail(e.getMessage());
            e.printStackTrace();
        }

    }

}
/**
 *
 */