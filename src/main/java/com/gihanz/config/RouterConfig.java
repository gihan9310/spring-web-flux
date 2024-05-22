package com.gihanz.config;

import com.gihanz.services.RequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@AllArgsConstructor
@Configuration
public class RouterConfig {

    private RequestHandler requestHandler;

    @Bean
    public RouterFunction<ServerResponse> serverResponseRouterFunction(){
        return RouterFunctions.route()
                .GET("/squar-app/{input}",requestHandler ::serverResponseMono)
                .GET("/squar-app/table/{input}",requestHandler ::serverResponseMono)
                .GET("/squar-app/stream/table/{input}",requestHandler ::tableHandelrStrem)
                .build();

    }

}
