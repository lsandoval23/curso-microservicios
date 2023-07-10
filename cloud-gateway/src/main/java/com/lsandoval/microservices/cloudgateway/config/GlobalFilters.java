package com.lsandoval.microservices.cloudgateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// Implementamos un filtro global que afectara a todas las solicitudes que vayan a Cloud Gateway
@Component
public class GlobalFilters implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // Pre filter: Antes de que vaya al microservicio correspondiente agregamos un header con el nombre callerName
        String callerName = "Cloud_Gateway";
        exchange.getRequest().mutate().header("callerName", callerName);

        return chain.filter(exchange).then( Mono.fromRunnable( () -> {

            // Post Filter: A la respuesta que nos devuelve el microservicio le añadimos un cookie y un header antes de
            //              devolver la respuesta
            exchange.getResponse().getCookies().add("RESPONSE", ResponseCookie.from("CALLER_NAME", callerName).build());
            exchange.getResponse().getHeaders().add("RESPONSE", callerName);

        }));
    }
}
