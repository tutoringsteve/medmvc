package com.sarasinsteven.medmvc.controllers;

import com.sarasinsteven.medmvc.repositories.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//indicates a controller component for a Spring MVC pattern
@Controller
public class DoctorController {

    //inject a patient repository into our controller on instantiation
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    //When we do an action against the URL of /doctors this method is going to be envoked.
    @RequestMapping("/doctors")
    public String getDoctors(Model model){

        model.addAttribute("doctors", doctorRepository.findAll());
        //This is going to be the view name.
        return "doctors/list";
    }
}
