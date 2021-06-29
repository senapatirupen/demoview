package com.example.demoview.web.controller;

import com.example.demoview.model.Address;
import com.example.demoview.model.Person;
import com.example.demoview.model.UserDetail;
import com.example.demoview.service.ApiCall;
import com.example.demoview.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
@SessionAttributes("userDetail")
public class EcomHomeController {

    @Autowired
    ApiCall apiCall;

    @ModelAttribute("userDetail")
    public UserDetail userDetail() {
        return new UserDetail();
    }

    @ModelAttribute("person")
    public Person defaultPerson() {
        Address address = new Address();
        address.setAddressLineOne("address line one");
        address.setAddressLineTwo("address line two");
        Address address1 = new Address();
        address.setAddressLineOne("address line three");
        address.setAddressLineTwo("address line four");
        ArrayList<Address> arrayList = new ArrayList<>();
        arrayList.add(address);
        arrayList.add(address1);
        Person person = new Person();
        person.setAddresses(arrayList);
        return person;
    }

    @ModelAttribute("addresses")
    public ArrayList<String> addressList(){
        ArrayList<String> addresses = new ArrayList<>();
        addresses.add("AddressLineOne, AddressLineTwo");
        addresses.add(("AddressLineThree, AddressLineFour"));
        return addresses;
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
        userDetail.setStatus("8147713016");
        userDetail.setPassword("thispassword");
        ResponseEntity<UserDetail> responseEntity =  apiCall.getUser("/signIn", userDetail);
        log.info(responseEntity.getBody().getFirstName());
        log.info("processLogin() " + userDetail);
        userDetail.setFirstName("Rupen");
        userDetail.setPhoneNumber("8147713016");
        userDetail.setDob(DateUtil.stringToDate("2021-02-12"));
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
        //rest template call to get the person out of userDetail
        //get list of address from person
        //add all the addresses to list of string after concatenation
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Address address = new Address();
        address.setType("Home");
        address.setAdId(1L);
        address.setAddressLineOne("address line one");
        address.setAddressLineTwo("address line two");
        Address address1 = new Address();
        address1.setType("Office");
        address1.setAdId(2L);
        address1.setAddressLineOne("address line three");
        address1.setAddressLineTwo("address line four");
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);
        model.addAttribute("addresses", addresses);
        return "profileaddress";
    }

    @RequestMapping(value = "/profileaddressedit")
    public String userProfileAddressEditPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam String id) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        Person person = new Person();
        //get address from person by address id
        Address address = new Address();
        address.setAddressLineOne("address line Four");
        address.setAddressLineTwo("address line Five");
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("address", address);
        return "profileaddressedit";
    }

    @RequestMapping(value = "/profileaddressedit", method = POST)
    public String userProfileAddressUpdatePage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        Person person = new Person();
        //get address from person by address id
        log.info("userProfileAddressUpdatePage() "+ address.getAddressLineOne());
        model.addAttribute("userDetail", userDetail);
        //need to remove
        Address address2 = new Address();
        address2.setType("Home");
        address2.setAdId(1L);
        address2.setAddressLineOne(address.getAddressLineOne());
        address2.setAddressLineTwo(address.getAddressLineTwo());
        Address address1 = new Address();
        address1.setType("Office");
        address1.setAdId(2L);
        address1.setAddressLineOne("address line three");
        address1.setAddressLineTwo("address line four");
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);
        model.addAttribute("addresses", addresses);
        return "profileaddress";
    }

    @RequestMapping(value = "/products")
    public String productsPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("address", "address");
        return "products";
    }

    @RequestMapping(value = "/productdetail")
    public String productdetailPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("address", "address");
        return "productdetail";
    }

    @RequestMapping(value = "/cart")
    public String cartPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("address", "address");
        return "cart";
    }


}
