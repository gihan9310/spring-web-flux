package com.gihanz.services;

import com.gihanz.dtos.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestHandler {

    @Autowired
    private ReactiveMathService  reactiveMathService ;

    public Mono<ServerResponse> serverResponseMono(ServerRequest serverRequest){
        int input = Integer.parseInt(serverRequest.pathVariable("input"));
        Mono<ResponseDTO> square = reactiveMathService.findSquare(input);
        return ServerResponse.ok().body(square,ResponseDTO.class);
    }
    public Mono<ServerResponse> tableHandelr(ServerRequest serverRequest){
        int input = Integer.parseInt(serverRequest.pathVariable("input"));
        Flux<ResponseDTO> responseDTOFlux = reactiveMathService.multiplicationTable(input);
        return ServerResponse.ok().body(responseDTOFlux,ResponseDTO.class);
    }
    public Mono<ServerResponse> tableHandelrStrem(ServerRequest serverRequest){
        int input = Integer.parseInt(serverRequest.pathVariable("input"));
        Flux<ResponseDTO> responseDTOFlux = reactiveMathService.multiplicationTable(input);
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM) .body(responseDTOFlux,ResponseDTO.class);
    }
}
