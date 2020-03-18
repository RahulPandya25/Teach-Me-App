package com.teach.me.app.Controller;

import com.teach.me.app.DTO.TestDTO;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Service.ParsingExcelFileService;
import com.teach.me.app.Service.TestService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private ParsingExcelFileService parsingExcelFileService;

    @PostMapping("/test/insert")
    private void insertTest(@RequestBody Test test){
        testService.insertTest(test);
    }
    @GetMapping("/test/all")
    private List<Test> getAllTests(){
        return testService.getAllTests();
    }
    @GetMapping("/test/{testId}")
    private Optional<Test> getTestByTestId(@PathVariable int testId){
        return testService.getTestById(testId);
    }

    @GetMapping("/subject/test/{subjectId}")
    private TestDTO getTestsBySubjectId(@PathVariable int subjectId){
        List<Test> tests = testService.getTestsBySubjectId(subjectId);
        TestDTO testDTO = new TestDTO();
        testDTO.setSubjectName(tests.get(0).getSubject().getName());
        testDTO.setSubjectId(subjectId);
        testDTO.setTestList(tests);
        return testDTO;
    }

    @PostMapping("/test")
    private void addQuestions() throws IOException, InvalidFormatException {
        System.out.println("Inside TestController");
        parsingExcelFileService.readFile();
    }
}
