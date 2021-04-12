package com.sarasinsteven.medmvc.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {

    @Id
    //tells Hibernate that the underlying database is going to be providing the generation of this
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    //Assign a many-to-many relationship between parents and doctors
    //See Doctor for the JoinTable
    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors = new HashSet<>();

    @ManyToMany(mappedBy = "patients")
    private Set<Disease> diseases = new HashSet<>();

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

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                doctorNames() +
                diseaseNames() +
                '}';
    }

    /**
     * Prints out a JSON like string of doctors {type1 first_name1 last_name1, type2 first_name2 last_name2,...}
     * @return JSON like string representing the list of doctors by type, first and last name.
     */
    public String doctorNames() {

        String names = "";

        if(doctors.size() != 0) {
            names += ", doctors={";

            int i = 0;


            for(Doctor d : doctors) {

                names += d.getType() + " " + d.getFirstName() + " " + d.getLastName();

                if(i < doctors.size() - 1) {
                    names += ", ";
                }

                i++;
            }

            names += "}";
        }

        return names;
    }

    /**
     * Prints out a JSON like string of diseases {type1, type2 ,...}
     * @return JSON like string representing the list of diseases by type.
     */
    public String diseaseNames() {

        String names = "";

        if(diseases.size() != 0) {
            names += ", diseases={";

            int i = 0;


            for(Disease d : diseases) {

                names += d.getType();

                if(i < diseases.size() - 1) {
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

        Patient patient = (Patient) o;

        return id != null ? id.equals(patient.id) : patient.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
