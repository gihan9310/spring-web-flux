package com.gihanz.services;

import com.gihanz.dtos.ResponseDTO;
import com.gihanz.utils.ThreadSleepUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class MathService {

    public ResponseDTO findSquare(int input){
       return new ResponseDTO(input * input);
    }

    public List<ResponseDTO>multiplicationTable(int input){

        return IntStream.rangeClosed(1,11)
                .peek(value -> ThreadSleepUtils.sleepSeconds(2))
                .peek(i -> System.out.println("Math Service Processing : "+i))
                .mapToObj(i->new ResponseDTO(i*input))
                .toList();
    }
}
