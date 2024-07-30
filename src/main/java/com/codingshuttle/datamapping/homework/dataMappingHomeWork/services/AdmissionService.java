package com.codingshuttle.datamapping.homework.dataMappingHomeWork.services;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.AdmissionRecordEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.repositories.AdmissionRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AdmissionService {
    private final AdmissionRecordRepository admissionRecordRepository;

    public AdmissionService(AdmissionRecordRepository admissionRecordRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public AdmissionRecordEntity getAdmissionNumber(Long admissionId) {
        return admissionRecordRepository.findById(admissionId).orElse(null);
    }


    public AdmissionRecordEntity createAdmissionEntity(AdmissionRecordEntity admissionRecord) {
        return admissionRecordRepository.save(admissionRecord);
    }
}
