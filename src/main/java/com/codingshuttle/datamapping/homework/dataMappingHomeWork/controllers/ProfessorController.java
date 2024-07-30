package com.codingshuttle.datamapping.homework.dataMappingHomeWork.controllers;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.ProfessorEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path = "/{professor_Id}/professor/{student_Id}")
    public ProfessorEntity assignProfessorToStudentEntity(@PathVariable Long professor_Id,
                                                          @PathVariable Long student_Id ){
        return professorService.assignProfessorToStudentEntity(professor_Id,student_Id);
    }

    @PutMapping(path = "/{professor_Id}/student/{subject_Id}")
        public ProfessorEntity assignProfessorToSubjectEntity(@PathVariable Long professor_Id,
                                                              @PathVariable Long subject_Id ){
        return professorService.assignProfessorToSubjectEntity(professor_Id,subject_Id);
    }

}
