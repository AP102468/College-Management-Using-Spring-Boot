package com.codingshuttle.datamapping.homework.dataMappingHomeWork.services;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.ProfessorEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.StudentEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.SubjectEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.ProfessorRepository;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.StudentRepository;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private Long professorId;
    private Long subjectId;

    public ProfessorService(ProfessorRepository professorRepository, StudentRepository studentRepository ,SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignProfessorToStudentEntity(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return professorEntity.flatMap(professor->
            studentEntity.map(student->{
                student.getProfessors().add(professor);
                professor.getAssignedStudents().add(student);
                professorRepository.save(professor);
                return professor;

            })).orElse(null);
    }


    public ProfessorEntity assignProfessorToSubjectEntity(Long professorId, Long subjectId ) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor->
                subjectEntity.map(subject ->{
                    subject.setProfessor(professor);
                    subjectRepository.save(subject);

                    professor.getTeachSubjects().add(subject);
                    return professor;
                })).orElse(null);
    }
}
