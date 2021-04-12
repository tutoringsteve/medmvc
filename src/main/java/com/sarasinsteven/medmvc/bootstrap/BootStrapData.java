package com.sarasinsteven.medmvc.bootstrap;

import com.sarasinsteven.medmvc.domain.Doctor;
import com.sarasinsteven.medmvc.domain.Patient;
import com.sarasinsteven.medmvc.repositories.DoctorRepository;
import com.sarasinsteven.medmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Constructs the H2 in-memory database for this application
 */
//generic stereotype for any Spring-managed component
@Component
public class BootStrapData implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public BootStrapData(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        //Create patients
        Patient ramanujan = new Patient();
        ramanujan.setFirstName("Srinivasa");
        ramanujan.setLastName("Ramanujan");

        Patient newton = new Patient();
        newton.setFirstName("Isassc");
        newton.setLastName("Newton");

        Patient noether = new Patient();
        noether.setFirstName("Emmy");
        noether.setLastName("Noether");

        //Create Doctors
        Doctor euler = new Doctor();
        euler.setFirstName("Leonard");
        euler.setLastName("Euler");
        euler.setType("General Practitioner");

        Doctor gauss = new Doctor();
        gauss.setFirstName("Carl");
        gauss.setLastName("Gauss");
        gauss.setType("Dermatologist");

        Doctor riemann = new Doctor();
        riemann.setFirstName("Bernard");
        riemann.setLastName("Riemann");
        riemann.setType("Oncologist");

        //assign doctors to patients
        ramanujan.getDoctors().add(euler);
        newton.getDoctors().add(euler);
        newton.getDoctors().add(gauss);
        newton.getDoctors().add(riemann);
        noether.getDoctors().add(euler);
        noether.getDoctors().add(gauss);

        //assign patients to doctors
        euler.getPatients().add(ramanujan);
        euler.getPatients().add(newton);
        euler.getPatients().add(noether);
        gauss.getPatients().add(newton);
        gauss.getPatients().add(noether);
        riemann.getPatients().add(newton);

        //save all patients and doctors
        patientRepository.save(ramanujan);
        patientRepository.save(newton);
        patientRepository.save(noether);
        doctorRepository.save(euler);
        doctorRepository.save(gauss);
        doctorRepository.save(riemann);

        System.out.println("Number of patients: " + patientRepository.count());
        System.out.println("Number of doctors: " + doctorRepository.count());

        System.out.println("Patients: " + ramanujan.toString() + ", " + newton.toString() + ", " + noether.toString());
        System.out.println("Dcotors: " + euler.toString() + ", " + gauss.toString() + ", " + riemann.toString());

    }
}
