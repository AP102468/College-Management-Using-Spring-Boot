package com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository  extends JpaRepository<ProfessorEntity,Long> {
}
