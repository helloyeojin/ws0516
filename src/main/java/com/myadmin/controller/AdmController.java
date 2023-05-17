package com.myadmin.controller;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Lecture;
import com.myadmin.service.AdmService;
import com.myadmin.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/adm")
public class AdmController {

    String dir = "adm/";
    @Autowired
    AdmService admService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        Adm adm = null;
        try {
            adm = admService.get(id);
            if(adm != null && encoder.matches(pwd, adm.getPwd())){
                session.setMaxInactiveInterval(60000);
                session.setAttribute("loginadm", adm);
                model.addAttribute("center", dir + "loginOk");
            } else{
                model.addAttribute("center", dir + "loginFail");
            }
        } catch (Exception e) {
            throw new Exception("adm login error");
        }
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        try {
            List<Adm> list = admService.get();
            model.addAttribute("adm",list);
            model.addAttribute("center",dir+"all");
        } catch (Exception e) {
            throw new Exception("adm all error");
        }
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Adm adm, HttpSession session) throws Exception {
        String nextPage = "registerFail";//Error Controller가 있어서 필요없음. 그냥 구현해 봄.
        try {
            adm.setPwd(encoder.encode(adm.getPwd()));
            admService.register(adm);
            nextPage = "registerOk";
            session.setMaxInactiveInterval(600000);
            session.setAttribute("loginadm", adm);
        } catch (Exception e) {
            throw new Exception("adm add error");
        }
        model.addAttribute("adm", adm);
        model.addAttribute("center", dir + nextPage);
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, String id) throws Exception {
        try {
            Adm adm = admService.get(id);
            model.addAttribute("adm", adm);
            model.addAttribute("center", dir+"detail");
        } catch (Exception e) {
            throw new Exception("adm detail error");
        }
        return "index";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Adm adm) throws Exception {
        try {
            adm.setPwd(encoder.encode(adm.getPwd()));
            admService.modify(adm);
        } catch (Exception e) {
            throw new Exception("adm update error");
        }
        return "redirect:/adm/detail?id="+adm.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, String id) throws Exception {
        try {
            admService.remove(id);
        } catch (Exception e) {
            throw new Exception("adm delete error");
        }
        return "redirect:/adm/all";
    }
}
