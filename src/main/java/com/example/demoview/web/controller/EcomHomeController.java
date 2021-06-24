package com.example.demoview.web.controller;

import com.example.demoview.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
@SessionAttributes("userDetail")
public class EcomHomeController {

    @ModelAttribute("userDetail")
    public UserDetail userDetail() {
        return new UserDetail();
    }

    @RequestMapping(value = "/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String processLogin(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("processLogin() " + userDetail);
        userDetail.setFirstName("Rupen");
        userDetail.setPhoneNumber("8147713016");
        userDetail.setDob("12-02-2021");
        model.addAttribute("userDetail", userDetail);
        return "headerwithuser";
    }

    @RequestMapping(value = "/signup")
    public String signUpPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = POST)
    public String processSignUp(@ModelAttribute UserDetail userDetail) {
        log.info("processLogin() " + userDetail);
        return "index";
    }

    @RequestMapping(value = "/headerwithuser")
    public String userPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "headerwithuser";
    }

    @RequestMapping(value = "/profile")
    public String userProfilePage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfilePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "profile";
    }

    @RequestMapping(value = "/profileedit")
    public String userProfileEditPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "profileedit";
    }

    @RequestMapping(value = "/profileupdate", method = POST)
    public String userProfileUpdatePage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "profile";
    }

    @RequestMapping(value = "/profileaddress")
    public String userProfileAddressPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "profileaddress";
    }

//    @RequestMapping(value="/signup", method = POST)
//    public String profile(@ModelAttribute UserDetail userDetail){
//        log.info("processLogin() "+userDetail);
//        return "index";
//    }
}
