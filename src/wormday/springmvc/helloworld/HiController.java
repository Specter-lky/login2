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
        //获取登录页面中表单提交的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //如果没填写用户名和密码，直接登录，就会报错，并跳转回登录页面index.jsp
        if(username==null){
            httpSession.setAttribute("error","还没登录，请先登录");
            return "redirect:/index.jsp";
        }
        User loginuser=new User(username,password);
        //如果登录发生错误，利用session传递登录错误的信息，跳转到登录页面index.jsp
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
            //如果登录成功，利用model传递登录成功信息，跳转到信息页面message.jsp
            model.addAttribute("status","欢迎你"+username+"，登录成功！");
            return "message";
        }
    }
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response,Model model) {
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //获取注册页面中表单提交的信息
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 =request.getParameter("password2");
        if (!password1.equals(password2)){
            //注册页面中，两次输入的密码不一致，返回注册页面register.jsp
            session.setAttribute("pass","两次密码不一致");
            return "register";
        }
        User user=new User(username,password1);
        if(userDao.check(username)==null){
            //注册成功，返回登录首页index.jsp
            session.setAttribute("success","注册成功");
            userDao.addUser(user);
            return "redirect:/index.jsp";
        }
        else {
            //注册时，填写的用户名已存在，返回注册页面register.jsp
            session.setAttribute("pass","用户名已存在");
            return "register";
        }
    }
}
