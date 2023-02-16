package security.springsecurity2_2023.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import security.springsecurity2_2023.user.User;

@Controller
@RequestMapping("/act")
public class ActController {

    private final PersonValidator personValidator;
    public static final String PEOPLE_REDIRECT_PAGE = "redirect:/people";

    private final PersonService personService;

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid User user,
                               BindingResult bindingResult) {

        personValidator.validate(person, bindingResult);

        if(bindingResult.hasErrors()) {
            return "/people/insert_into_person_page";
        }
        personService.addPerson(person);
        return PEOPLE_REDIRECT_PAGE;

    }

}
