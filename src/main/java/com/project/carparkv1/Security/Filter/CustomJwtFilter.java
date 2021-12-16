package com.project.carparkv1.Security.Filter;

import com.project.carparkv1.Security.SecurityService.MyUserDetailsService;
import com.project.carparkv1.Security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class CustomJwtFilter extends OncePerRequestFilter {

    private final MyUserDetailsService myUserDetailsService;

    private final JwtUtil jwtUtil;

    Logger logger = LoggerFactory.getLogger(CustomJwtFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        logger.info("Check in Jwt Filter");

        if (request.getServletPath().equals("/login")) {
            filterChain.doFilter(request, response);
        }

        final String authenticationHeader = request.getHeader("MyJwtToken");
        if (authenticationHeader != null && authenticationHeader.startsWith("Bearer ")){
            String token = authenticationHeader.substring("Bearer ".length());
            if(jwtUtil.validate(token)){
                String username = jwtUtil.getUsername(token);
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);
            }
            else {
                filterChain.doFilter(request, response);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }


    }
}

