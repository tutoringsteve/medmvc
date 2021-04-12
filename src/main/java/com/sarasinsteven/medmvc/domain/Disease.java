package com.sarasinsteven.medmvc.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Disease {

    @Id
    //tells Hibernate that the underlying database is going to be providing the generation of this
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @ManyToMany
    @JoinTable(name = "patient_disease", joinColumns = @JoinColumn(name = "disease_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patients = new HashSet<>();

    //JPA requires a 0 arg constructor
    public Disease() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "type='" + type + '\'' +
                patientNames() +
                '}';
    }

    /**
     * Prints out a JSON like string of patients {first_name1 last_name1, first_name2 last_name2,...}
     * @return JSON like string representing the list of patients by first and last name.
     */
    public String patientNames() {

        String names = "";

        if(patients.size() != 0) {
            names += ", patients={";

            int i = 0;


            for(Patient p : patients) {

                names += p.getFirstName() + " " + p.getLastName();

                if(i < patients.size() - 1) {
                    names += ", ";
                }

                i++;
            }

            names += "}";
        }

        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disease disease = (Disease) o;

        return id != null ? id.equals(disease.id) : disease.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
