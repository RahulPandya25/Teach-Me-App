package com.teach.me.app.ServiceImpl;


import com.teach.me.app.Enum.Difficulty;
import com.teach.me.app.Enum.Option;
import com.teach.me.app.Model.Question;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Repository.QuestionRepository;
import com.teach.me.app.Service.ParsingExcelFileService;
import com.teach.me.app.Service.QuestionService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ParsingExcelFileServiceImpl implements ParsingExcelFileService {

    @Autowired
    QuestionService questionService;

    @Override
    public void readFile() throws IOException, InvalidFormatException {

        //adding static path temporarily
        String filePath = "F:\\Advanced Software Engineering Concepts\\Final Project\\Teach-Me-App\\src\\main\\resources\\Book1.xlsx";
        System.out.println(filePath);
        File file = new File(filePath);
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get the sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.println(cell.toString());
            }
        }

        Test test = new Test();
        test.setTestId(1);
        test.setName("Arrays");
        test.setNumberOfQuest(10);
        test.setTotalTime(120);
        System.out.println(sheet.getLastRowNum());
        for(int i = 1; i <= sheet.getLastRowNum(); i ++){
            System.out.println("Inside for loop");
            Question question = new Question();
            Row row = sheet.getRow(i);
            question.setDescription(row.getCell(1).toString());
            question.setOption_1(row.getCell(2).toString());
            question.setOption_2(row.getCell(3).toString());
            question.setOption_3(row.getCell(4).toString());
            question.setOption_4(row.getCell(5).toString());
            question.setAnswer(Option.valueOf(row.getCell(6).getStringCellValue().toUpperCase()));
            question.setDifficulty(Difficulty.valueOf(row.getCell(7).getStringCellValue().toUpperCase()));
            question.setTest(test);
            System.out.println(question.toString());
            questionService.insertQuestion(question);
        }

    }
}
