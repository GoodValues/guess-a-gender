package com.niewiadomski.guessagender.controller;

import com.niewiadomski.guessagender.dto.ComplexTokenDTO;
import com.niewiadomski.guessagender.entity.ComplexToken;
import com.niewiadomski.guessagender.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TokenController {

    TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @GetMapping(value="/")
    public String mainPage() {
        return "index";
    }

    @ResponseBody
    @PostMapping("/getToken")
    public ComplexTokenDTO getToken(@RequestParam(name = "givenName") String givenName, @RequestParam String checkingMethod) {

        ComplexTokenDTO complexTokenDTO = new ComplexTokenDTO();

        if(checkingMethod.equals("method1")) {
            complexTokenDTO = tokenService.getComplexTokenFirstOptionChecked(givenName);
        } else if(checkingMethod.equals("method2")) {
            complexTokenDTO = tokenService.getComplexTokenSecondOptionChecked(givenName);
        }
        return complexTokenDTO;
    }

    @GetMapping(value="/getTokenForFirstMethod", produces = "application/json")
    public String getTokenForFirstMethod() {
        return "index";
    }

    @GetMapping(value="/getTokenForSecondMethod", produces = "application/json")
    public String getTokenForSecondMethod() {
        return "index";
    }
}
