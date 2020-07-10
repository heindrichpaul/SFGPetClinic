package com.heindrich.sfgpetclinic.controllers;

import com.heindrich.sfgpetclinic.model.Vet;
import com.heindrich.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * Created by heindrichpaul on 11/02/2020
 */
@Controller
public class VetController {
    private final VetService vetService;

    public static final String VIEW_VET_INDEX = "vets/index";

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", vetService.findAll());
        return VIEW_VET_INDEX;
    }

    @GetMapping("/api/vets")
    public @ResponseBody
    Set<Vet> getVetsJSON() {
        return vetService.findAll();
    }
}
