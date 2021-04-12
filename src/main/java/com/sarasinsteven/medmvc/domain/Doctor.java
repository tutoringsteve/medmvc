package com.sarasinsteven.medmvc.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    //tells Hibernate that the underlying database is going to be providing the generation of this
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String type;

    @ManyToMany
    @JoinTable(name = "patient_doctor", joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patients = new HashSet<>();

    //JPA requires a 0 arg constructor
    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
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


    //Have to override equals and hashCode to base equals off of the generated ID so that Hibernate and things like Sets consider objects with the same ID to be equal.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        return id != null ? id.equals(doctor.id) : doctor.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
