package com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
