package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginServletFiltr implements Filter {

    // jeśli jest username w sesi to przepuść

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");

        String requestUri = httpServletRequest.getRequestURI();

        if (username != null
                || requestUri.endsWith("login.jsp")
                || requestUri.endsWith("login")
                || requestUri.endsWith(".css")
                || requestUri.endsWith("register.jsp")
                || requestUri.endsWith("registration")
                || requestUri.endsWith("userDAOTest")
                || requestUri.endsWith("moviesDaoTest")
                ) {

//    ta linijka przepuszcza. Jeśli damy tylko to- przepuścimy wszytsko
            filterChain.doFilter(req, resp);
        } else {
            httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL("login.jsp"));
        }

    }

    @Override
    public void destroy() {
    }
}
