package com.teach.me.app.Controller;

import com.teach.me.app.DTO.TestDTO;
import com.teach.me.app.Exception.SubjectNotFoundException;
import com.teach.me.app.Exception.TestNotFoundException;
import com.teach.me.app.Model.Subject;
import com.teach.me.app.Model.Test;
import com.teach.me.app.Service.ParsingExcelFileService;
import com.teach.me.app.Service.SubjectService;
import com.teach.me.app.Service.TestService;
import com.teach.me.app.Service.UploadFileService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ParsingExcelFileService parsingExcelFileService;

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping("/test/insert")
    private void insertTest(@RequestBody Test test, @RequestParam MultipartFile file){
        test = testService.insertTest(test);
        uploadFileService.saveFile(file);
    }
    @GetMapping("/test/all")
    private List<Test> getAllTests(){
        List<Test> testList = new ArrayList<Test>();
        testList = testService.getAllTests();
        return testList;
    }
    @GetMapping("/test/{testId}")
    private Test getTestByTestId(@PathVariable int testId) throws TestNotFoundException {
         return testService.getTestById(testId);
    }

    @GetMapping("/subject/test/{subjectId}")
    private TestDTO getTestsBySubjectId(@PathVariable int subjectId) throws SubjectNotFoundException {
        Subject subject = subjectService.getSubjectById(subjectId);
        List<Test> tests = new ArrayList<Test>();
        tests = testService.getTestsBySubjectId(subjectId);
        TestDTO testDTO = new TestDTO();
        testDTO.setSubjectName(subject.getName());
        testDTO.setSubjectId(subjectId);
        testDTO.setTestList(tests);
        return testDTO;

    }

    @PostMapping("/test")
    private void addQuestions() throws IOException, InvalidFormatException {
        parsingExcelFileService.readFile();
    }
}
