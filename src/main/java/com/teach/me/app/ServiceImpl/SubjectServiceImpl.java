package com.teach.me.app.ServiceImpl;

import com.teach.me.app.Model.Subject;
import com.teach.me.app.Repository.SubjectRepository;
import com.teach.me.app.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    /**
     * @param subject
     */
    @Override
    public void insertSubject(Subject subject) {
        System.out.println("Inside SubjectServiceImpl: "+ subject.toString());
        subjectRepository.save(subject);
    }

    /**
     * @return
     */
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    /**
     * @param subjectId
     * @return
     */
    @Override
    public Optional<Subject> getSubjectById(int subjectId) {
        return subjectRepository.findById(subjectId);
    }
}
