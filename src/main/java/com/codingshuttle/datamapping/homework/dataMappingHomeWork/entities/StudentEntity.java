package com.codingshuttle.datamapping.homework.dataMappingHomeWork.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "assignedStudents")
    @JsonIgnore
    private Set<ProfessorEntity> professors;

    @ManyToMany
    @JoinTable(name = "study_subjects_mapping",
            joinColumns = @JoinColumn(name = "subject_Id"),
            inverseJoinColumns = @JoinColumn (name = "student_Id"))
    private Set<SubjectEntity> studySubjects;

    @OneToOne
    @JoinColumn(name = "admission_id")
    private AdmissionRecordEntity admissionTaken;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
