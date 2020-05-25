/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/21/2020 1:44 PM
 */
package com.slmora.morajavafileaccess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 5/21/2020 1:44 PM
 * <p>
 * Version      Date            Editor              Note
 * ---------    ----------      ----------------    --------------------------------------------------------------------
 * 1.0          5/21/2020      SLMORA                Initial Code
 */
public class TestRun {
    public static void main(String[] args) {
        GenerateDBScript generateDBScript=new GenerateDBScript();
//        generateDBScript.setInFileID("D:\\SLMORAWorkSpace\\LTAWork\\ID.txt");
//        generateDBScript.setInFileSortName("D:\\SLMORAWorkSpace\\LTAWork\\SNAME.txt");
//        generateDBScript.setInFileDescription("D:\\SLMORAWorkSpace\\LTAWork\\DES.txt");
//        generateDBScript.setInFileLocationLocalMode("D:\\SLMORAWorkSpace\\LTAWork\\MOD1.txt");
//        generateDBScript.setInFileParamDescriptionMode("D:\\SLMORAWorkSpace\\LTAWork\\MOD2.txt");
//        generateDBScript.setOutFileLocationLocal("D:\\SLMORAWorkSpace\\LTAWork\\OUT1.txt");
//        generateDBScript.setOutFileParamDescription("D:\\SLMORAWorkSpace\\LTAWork\\OUT2.txt");
//
//        generateDBScript.generateScript();

        new FileAccess().fileAccessTest();

    }
}
/**
 *
 */
