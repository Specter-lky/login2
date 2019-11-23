package wormday.springmvc.helloworld;
import com.dao.UserDao;
import com.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/hi")
public class HiController {
    @Resource
    private UserDao userDao;
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response,Model model) {
        HttpSession httpSession=request.getSession(true);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser=new User(username,password);
        if(userDao.login(loginuser)==null){
            if (userDao.check(username)==null){
                httpSession.setAttribute("error","用户不存在,请先注册");
            }
            else {
                httpSession.setAttribute("error","密码错误");
            }
            return "redirect:/index.jsp";
        }
        else {
            model.addAttribute("status","欢迎你"+username+"，登录成功！");
            return "message";
        }
    }
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response,Model model) {
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 =request.getParameter("password2");
        if (!password1.equals(password2)){
            session.setAttribute("pass","两次密码不一致");
            return "/register";
        }
        User user=new User(username,password1);
        if(userDao.check(username)==null){
            session.setAttribute("success","注册成功");
            userDao.addUser(user);
            return "redirect:/index.jsp";
        }
        else {
            session.setAttribute("pass","用户名已存在");
            return "register";
        }
    }
}
