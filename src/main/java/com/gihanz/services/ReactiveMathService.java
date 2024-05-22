package com.gihanz.services;


import com.gihanz.dtos.ResponseDTO;
import com.gihanz.utils.ThreadSleepUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class ReactiveMathService {


    public Mono< ResponseDTO> findSquare(int input){
        return Mono.fromSupplier(()->input*input)
                .map(ResponseDTO::new);
    }

    public Flux<ResponseDTO> multiplicationTable(int input){

        return Flux.range(1,10)
                .doOnNext(i->ThreadSleepUtils.sleepSeconds(1))
                .doOnNext(i-> System.out.println("Sleeping Index : "+i))
                .map(i->new ResponseDTO(i*input));
    }
}
