package com.codingshuttle.datamapping.homework.dataMappingHomeWork.controllers;

import com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities.AdmissionRecordEntity;
import com.codingshuttle.datamapping.homework.dataMappingHomeWork.services.AdmissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admissions")
public class AdmissionController {

    private final AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @GetMapping(path = "/{admissionId}")
    public AdmissionRecordEntity getAdmissionNumber(@PathVariable Long admissionId){
        return admissionService.getAdmissionNumber(admissionId);
    }
    @PostMapping
    public AdmissionRecordEntity createAdmissionEntity(@RequestBody AdmissionRecordEntity admissionRecord){
        return admissionService.createAdmissionEntity(admissionRecord);
    }
}
