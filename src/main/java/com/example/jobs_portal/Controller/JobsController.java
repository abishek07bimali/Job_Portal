package com.example.jobs_portal.Controller;


import com.example.jobs_portal.entity.Jobs;
import com.example.jobs_portal.entity.User;
import com.example.jobs_portal.pojo.ApplicationPojo;
import com.example.jobs_portal.pojo.JobsPojo;
import com.example.jobs_portal.pojo.UserPojo;
import com.example.jobs_portal.service.ApplicationService;
import com.example.jobs_portal.service.JobsService;
import com.example.jobs_portal.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobsController {
//    @Autowired
    private  final JobsService jobsService;
    private  final UserService userService;
    private  final ApplicationService applicationService;

    @GetMapping("/newpage")
    public String getRegisterPage(Model model) {
        List<Jobs> users = jobsService.fetchAll();
        model.addAttribute("joblist", users);
        return "user/newpage";
    }


    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }


}
