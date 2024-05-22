package com.gihanz.controllers;

import com.gihanz.dtos.ResponseDTO;
import com.gihanz.services.MathService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "math")
@AllArgsConstructor
public class MathController {


    private final MathService mathService ;

    @GetMapping(value = "square/{input}")
    public ResponseDTO  findSquare(@PathVariable ("input") int input){
        return  mathService.findSquare(input);
    }
    @GetMapping(value = "table/{input}")
    public List< ResponseDTO> multifyTable(@PathVariable ("input") int input){
        return  mathService.multiplicationTable(input);
    }
}
