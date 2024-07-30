package com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}
