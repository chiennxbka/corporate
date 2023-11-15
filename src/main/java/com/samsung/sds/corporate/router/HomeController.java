package com.samsung.sds.corporate.router;

import com.samsung.sds.corporate.payload.ContactPayload;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping
    public ModelAndView home(ModelMap modelMap){
        var payload = new ContactPayload();
        var language = LocaleContextHolder.getLocale();
        modelMap.addAttribute("payload", payload);
        modelMap.addAttribute("language", language.toLanguageTag());
        return new ModelAndView("index", modelMap);
    }

    @GetMapping(value = "portfolio")
    public ModelAndView portfolio(ModelMap modelMap){
        return new ModelAndView("portfolio-details", modelMap);
    }
}
