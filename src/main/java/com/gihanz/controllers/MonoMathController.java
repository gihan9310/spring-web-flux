package com.gihanz.controllers;

import com.gihanz.dtos.ResponseDTO;
import com.gihanz.services.MathService;
import com.gihanz.services.ReactiveMathService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "mono-math")
@AllArgsConstructor
public class MonoMathController {

    private final ReactiveMathService  reactiveMathService ;

    @GetMapping(value = "square/{input}")
    public Mono< ResponseDTO> findSquare(@PathVariable("input") int input){
        return  reactiveMathService.findSquare(input);
    }
    @GetMapping(value = "table/{input}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux< ResponseDTO> multifyTable(@PathVariable ("input") int input){
        return  reactiveMathService.multiplicationTable(input);
    }
    @PostMapping(value = "table/{input}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux< ResponseDTO> flux(@RequestBody Flux<ResponseDTO> list){
//        list.map()
        return null;
    }
}
