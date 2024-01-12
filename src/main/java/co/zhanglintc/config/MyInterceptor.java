package co.zhanglintc.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long ts = System.currentTimeMillis();
        if (ts % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
