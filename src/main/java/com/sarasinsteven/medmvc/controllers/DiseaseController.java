package com.sarasinsteven.medmvc.controllers;

import com.sarasinsteven.medmvc.repositories.DiseaseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//indicates a controller component for a Spring MVC pattern
@Controller
public class DiseaseController {

    //inject a patient repository into our controller on instantiation
    private final DiseaseRepository diseaseRepository;

    public DiseaseController(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    //When we do an action against the URL of /diseases this method is going to be envoked.
    @RequestMapping("/diseases")
    public String getDiseases(Model model){

        model.addAttribute("diseases", diseaseRepository.findAll());
        //This is going to be the view name.
        return "diseases/list";
    }
}
