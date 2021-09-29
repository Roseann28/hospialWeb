package com.cohort.nine.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AccessFilter", urlPatterns = "/*")
public class AccessFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String servletPath = httpServletRequest.getServletPath();

        HttpSession session = httpServletRequest.getSession();

        if (session.isNew()){
            session.invalidate();

            if (servletPath.equals("/homePage.jsp")){
                chain.doFilter(request, response);
                response.getWriter().flush();
            }

            else
                ((HttpServletResponse) response).sendRedirect("http://localhost:8080/HospitalWeb/homePage.jsp");

        }else{
            chain.doFilter(request, response);

        }
    }

    public void destroy() {

    }

}
