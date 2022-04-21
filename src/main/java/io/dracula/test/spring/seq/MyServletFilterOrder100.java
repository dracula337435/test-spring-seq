package io.dracula.test.spring.seq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(100)
@Component
@WebFilter
public class MyServletFilterOrder100 extends OncePerRequestFilter {

    private static Logger logger = LoggerFactory.getLogger(MyServletFilterOrder100.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("in ServletFilter.doFilterInternal, Order 100, before filterChain.doFilter");
        filterChain.doFilter(request, response);
        logger.info("in ServletFilter.doFilterInternal, Order 100, after filterChain.doFilter");
    }

}
