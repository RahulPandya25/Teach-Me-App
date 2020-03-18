package com.teach.me.app.Service;

import com.teach.me.app.Model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubjectService {
    /**
     *
     * @param subject
     */
    public void insertSubject(Subject subject);

    /**
     *
     * @return
     */
    public List<Subject> getAllSubjects();

    /**
     *
     * @param id
     * @return
     */
    public Optional<Subject> getSubjectById(int id);
}
