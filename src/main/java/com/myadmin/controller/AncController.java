package com.myadmin.controller;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Anc;
import com.myadmin.dto.Lecture;
import com.myadmin.service.AdmService;
import com.myadmin.service.AncService;
import com.myadmin.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/anc")
public class AncController {

    String dir = "anc/";
    @Value("${uploadimgdir}")
    String imgdir;

    @Autowired
    AncService ancService;
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        try {
            List<Anc> list = ancService.get();
            model.addAttribute("anc",list);
            model.addAttribute("center",dir+"all");
        } catch (Exception e) {
            throw new Exception("anc all error");
        }
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, Anc anc) throws Exception {
        MultipartFile mf = anc.getImgfile();
        String img = mf.getOriginalFilename();
        anc.setImg(img);
        try {
            ancService.register(anc);
            FileUploadUtil.saveFile(mf,imgdir);
        } catch (Exception e) {
            throw new Exception("anc add error");
        }
//        model.addAttribute("center", dir + "all");
//        model all로 던지면 foreach 오류가 발생. list를 model로 또 던져줘야함
        return "redirect:/anc/all";
    }

    @RequestMapping("/detail")
    public String detail(Model model, Integer id) throws Exception {
        try {
            Anc anc = ancService.get(id);
            model.addAttribute("anc", anc);
            model.addAttribute("center", dir+"detail");
        } catch (Exception e) {
            throw new Exception("anc detail error");
        }
        return "index";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, Anc anc) throws Exception {
        MultipartFile mf = anc.getImgfile();
        String new_img = mf.getOriginalFilename();
        if(new_img==null || new_img.equals("")){
            try {
                ancService.modify(anc);
            } catch (Exception e) {
                throw new Exception("anc modify error");
            }
        } else{
            try {
                anc.setImg(new_img);
                ancService.modify(anc);
                FileUploadUtil.saveFile(mf, imgdir);
            } catch (Exception e) {
                throw new Exception("anc modify error");
            }
        }
        return "redirect:/anc/detail?id="+anc.getId();
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, Integer id) throws Exception {
        try {
            ancService.remove(id);
        } catch (Exception e) {
            throw new Exception("anc delete error");
        }
        return "redirect:/anc/all";
    }
}
