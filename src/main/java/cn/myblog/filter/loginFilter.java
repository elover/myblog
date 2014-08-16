package cn.myblog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nanwei on 14-8-3.
 */
public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        if (path.toLowerCase().startsWith("/admin/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (request.getSession().getAttribute("login") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect(request.getContextPath() + "/admin/login");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
