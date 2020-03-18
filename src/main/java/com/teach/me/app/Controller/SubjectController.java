package com.teach.me.app.Controller;

import com.teach.me.app.Model.Subject;
import com.teach.me.app.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/insert")
    private void insertSubject(@RequestBody Subject subject){
        System.out.println("Inside SubjectController: "+ subject.toString());
        subjectService.insertSubject(subject);
    }

    @GetMapping("/all")
    private List getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    private Optional<Subject> getSubjectById(@PathVariable int subjectId){
        return subjectService.getSubjectById(subjectId);
    }


}
