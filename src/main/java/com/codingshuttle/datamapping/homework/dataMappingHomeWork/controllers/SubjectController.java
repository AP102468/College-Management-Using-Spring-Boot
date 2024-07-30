package com.codingshuttle.datamapping.homework.dataMappingHomeWork.controllers;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.SubjectEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createSubject(@RequestBody SubjectEntity subject){
        return subjectService.createSubject(subject);
    }

    @PutMapping(path = "/{subjectId}/subject/{studentId}")
    public SubjectEntity assignSubjectToStudentEntity(@PathVariable Long subjectId,
                                                      @PathVariable Long studentId){
        return subjectService.assignSubjectToStudentEntity(subjectId,studentId);
    }
}
