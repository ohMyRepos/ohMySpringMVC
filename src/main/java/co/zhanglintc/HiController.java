package co.zhanglintc;

import co.zhanglintc.pojo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {
    @RequestMapping("hi")
    public String hi(String name, Model model) {
        model.addAttribute("msg", "Hi, SpringMVC: " + name);
        return "hello"; // 这个就是view的名字
    }

    @RequestMapping(value = "json", produces = "application/json; charset=utf8")
    @ResponseBody
    public String json() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        Person user = new Person("Jack", 33, "男");
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }
}
