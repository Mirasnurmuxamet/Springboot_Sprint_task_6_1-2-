package kz.techboot.Sprint_task_61.controller;

import kz.techboot.Sprint_task_61.models.ApplicationRequest;
import kz.techboot.Sprint_task_61.repository.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.getAllOrderByHandle();
        model.addAttribute("requestList", applicationRequestList);
        return "index";
    }

    @GetMapping(value = "/add_applicationRequest")
    public String addApplicationRequestPage(){
        return "addApplicationRequest";
    }

    @PostMapping(value = "/add_applicationRequest")
    public String addApplicationRequest(ApplicationRequest applicationRequest){
        applicationRequest.setHandled(false);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/new_applicationRequest")
    public String newApplicationRequest(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAllByHandledIsFalse();
        model.addAttribute("requestList", applicationRequestList);
        return "newApplicationRequest";
    }

    @GetMapping(value = "/handled_applicationRequest")
    public String handledApplicationRequest(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAllByHandledIsTrue();
        model.addAttribute("requestList", applicationRequestList);
        return "handledApplicationRequest";
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model){
        ApplicationRequest applicationRequest = applicationRequestRepository.findById(id).orElse(null);
        model.addAttribute("requestlist", applicationRequest);
        return "details";

    }

    @PostMapping(value = "/update")
    public String update(ApplicationRequest applicationRequest){
        applicationRequest.setHandled(true);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/details/"+applicationRequest.getId();
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(value = "request_id") Long id){
        applicationRequestRepository.deleteById(id);
        return "redirect:/";
    }


}
