package com.sarasinsteven.medmvc.controllers;

import com.sarasinsteven.medmvc.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//indicates a controller component for a Spring MVC pattern
@Controller
public class PatientController {

    //inject a patient repository into our controller on instantiation
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //When we do an action against the URL of /patients this method is going to be envoked.
    @RequestMapping("/patients")
    public String getBooks(Model model){

        model.addAttribute("patients", patientRepository.findAll());
        //This is going to be the view name.
        return "patients/list";
    }
}
