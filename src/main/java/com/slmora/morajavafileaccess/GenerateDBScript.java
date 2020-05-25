/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 5/21/2020 1:44 PM
 */
package com.slmora.morajavafileaccess;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Data
public class GenerateDBScript {
    private String outFileLocationLocal;
    private String outFileParamDescription;
    private String inFileID;
    private String inFileSortName;
    private String inFileDescription;
    private String inFileLocationLocalMode;
    private String inFileParamDescriptionMode;

    private List readFileForContent(String filePath){
        List<String> list = new ArrayList<>();
        try (Stream<String> fileStream = Files.lines(Paths.get(filePath))) {
            list = fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void generateScript(){
        List<String> listID=readFileForContent(inFileID);
        List<String> listSortName=readFileForContent(inFileSortName);
        List<String> listDescription=readFileForContent(inFileDescription);

        try (PrintWriter writer = new PrintWriter(outFileLocationLocal);
                PrintWriter writer2 = new PrintWriter(outFileLocationLocal)){
            writer.print("");
            writer2.print("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i=0; i<listID.size(); i++){
            writeContent(listID.get(i),
                    listSortName.get(i),
                    listDescription.get(i),
                    inFileLocationLocalMode,
                    outFileLocationLocal);
            writeContent(listID.get(i),
                    listSortName.get(i),
                    listDescription.get(i),
                    inFileParamDescriptionMode,
                    outFileParamDescription);
        }

    }

    private void writeContent(
            String lineId,
            String lineSortName,
            String lineDescription,
            String inFIle,
            String outFile){
        List<String> list = new ArrayList<>();
        try(Stream<String> fileStream = Files.lines(Paths.get(inFIle))){
            list = fileStream
                    .map(line -> line.replaceAll("999888999111",lineId))
                    .map(line -> line.replaceAll("999888999112", StringUtils.leftPad(lineId,4,"0")))
                    .map(line -> line.replaceAll("999888999222",lineDescription))
                    .map(line -> line.replaceAll("999888999333",lineSortName))
                    .collect(Collectors.toList());
            Files.write(Paths.get(outFile),list, StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
/**
 *
 */
