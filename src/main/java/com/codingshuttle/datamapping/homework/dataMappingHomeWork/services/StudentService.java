package com.codingshuttle.datamapping.homework.dataMappingHomeWork.services;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.AdmissionRecordEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.StudentEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.AdmissionRecordRepository;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public StudentService(StudentRepository studentRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.studentRepository = studentRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }


    public StudentEntity assignAdmissionIdToStudentEntity(Long studentId, Long admissionId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<AdmissionRecordEntity> enrolledEntity = admissionRecordRepository.findById(admissionId);

        return studentEntity.flatMap(student->
               enrolledEntity.map(enrolled->{
                       student.setAdmissionTaken(enrolled);
                        return studentRepository.save(student);
               })).orElse(null);
    }


    public StudentEntity getStudentByAdmissionId(Long admissionId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionId);

        return admissionRecordEntity.map(admission->
                admission.getStudent()).orElse(null);

    }
}
