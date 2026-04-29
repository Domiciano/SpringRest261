package edu.co.icesi.introspringboot.security.filters;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            System.out.println("Authorization Header: " + authHeader);
        } else {
            System.out.println("No Authorization header present for " + request.getRequestURI());
        }

        // Esta línea permite seguir al siguiente eslabón de la cadena
        filterChain.doFilter(request, response);
    }
}
