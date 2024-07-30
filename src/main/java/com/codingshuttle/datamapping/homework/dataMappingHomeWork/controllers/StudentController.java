package com.codingshuttle.datamapping.homework.dataMappingHomeWork.controllers;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.StudentEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
            return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping(path = "/{studentId}/enrolled/{admissionId}")
    public StudentEntity assignAdmissionIdToStudentEntity(@PathVariable Long studentId,
                                                          @PathVariable Long admissionId){
        return studentService.assignAdmissionIdToStudentEntity(studentId,admissionId);
    }

    @GetMapping("/getStudentByAdmissionId/{admissionId}")
    public StudentEntity getStudentByAdmissionId(@PathVariable Long admissionId){
        return studentService.getStudentByAdmissionId(admissionId);

    }


}
