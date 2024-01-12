package co.zhanglintc.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long ts = System.currentTimeMillis();
        if (ts % 5 == 0) {
            // 本质是返回302，让客户端自己重新发起请求
            // response.sendRedirect("/intercepted");

            // 本质是服务器端重定向，所以更优
            request.getRequestDispatcher("/intercepted").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
