package com.codingshuttle.datamapping.homework.dataMappingHomeWork.services;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.StudentEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.SubjectEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.StudentRepository;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    private final StudentRepository studentRepository;

    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public SubjectEntity createSubject(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }


    public SubjectEntity assignSubjectToStudentEntity(Long subjectId, Long studentId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return subjectEntity.flatMap(subject->
                studentEntity.map(student->{
                    student.getStudySubjects().add(subject);
                    studentRepository.save(student);

                    subject.getStudents().add(student);
                    return subject;
                })).orElse(null);
    }
}
