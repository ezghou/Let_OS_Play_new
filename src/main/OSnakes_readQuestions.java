package main;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class OSnakes_readQuestions {
    ArrayList<String> header = new ArrayList<>();
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> topic = new ArrayList<>();
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> choice1 = new ArrayList<>();
    ArrayList<String> choice2 = new ArrayList<>();
    ArrayList<String> choice3 = new ArrayList<>();
    ArrayList<String> choice4 = new ArrayList<>();
    ArrayList<String> correctAnswer = new ArrayList<>();

    DataFormatter formatter;
    String cellContent;

    OSnakes_readQuestions() {
        String excelFilePath = "questions.xlsx";
        formatter = new DataFormatter();
        try( FileInputStream inputStream = new FileInputStream(excelFilePath)){
            XSSFWorkbook importedFile = new XSSFWorkbook(inputStream);
            XSSFSheet theoretical = importedFile.getSheetAt(0);
            for (Row row : theoretical) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (row.getRowNum() == 0) {
                        header.add(cell.getStringCellValue());
                    } else {
                        switch (cell.getColumnIndex()) {
                            case 0 -> id.add((int) cell.getNumericCellValue());
                            case 1 -> topic.add(cell.getStringCellValue());
                            case 2 -> questions.add(cell.getStringCellValue());
                            case 3 -> {
                                        cellContent = formatter.formatCellValue(cell);
                                        choice1.add(cellContent);
                                        }
                            case 4 -> {
                                        cellContent = formatter.formatCellValue(cell);
                                        choice2.add(cellContent);
                                        }
                            case 5 -> {
                                cellContent = formatter.formatCellValue(cell);
                                choice3.add(cellContent);
                            }
                            case 6 -> {
                                cellContent = formatter.formatCellValue(cell);
                                choice4.add(cellContent);
                            }
                            case 7 -> {
                                cellContent = formatter.formatCellValue(cell);
                                correctAnswer.add(cellContent);
                            }
                        }
                    }
                }
            }
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null, "File Not Found. Re-check the questionsFile.xlsx file");
        }
        System.out.println("size: "+questions.size());
    }

    public ArrayList<String> questions(){
        return questions;
    }
    public ArrayList<String> choice1(){
        return choice1;
    }
    public ArrayList<String> choice2(){
        return choice2;
    }
    public ArrayList<String> choice3(){
        return choice3;
    }
    public ArrayList<String> choice4(){
        return choice4;
    }
    public ArrayList<String> correctAnswer(){
        return correctAnswer;
    }
}
