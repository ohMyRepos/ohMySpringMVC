package co.zhanglintc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HiController {
    @RequestMapping("hi")
    public String hi(Model model) {
        model.addAttribute("msg", "Hi, SpringMVC");
        return "hello"; // 这个就是view的名字
    }
}
