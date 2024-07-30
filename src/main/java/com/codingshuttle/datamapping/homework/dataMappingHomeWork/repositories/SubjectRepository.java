package com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository  extends JpaRepository<SubjectEntity,Long> {
}
