
package com.vdenotaris.spring.boot.security.saml.web.controllers;

import com.vdenotaris.spring.boot.security.saml.web.stereotypes.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
    // Logger
    private static final Logger LOG = LoggerFactory.getLogger(LandingController.class);

    @RequestMapping("/landing")
    public String landing(@CurrentUser User user, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null)
            LOG.debug("Current authentication instance from security context is null");
        else
            LOG.debug("Current authentication instance from security context: "
                    + this.getClass().getSimpleName());
        model.addAttribute("username", user.getUsername());
        return "pages/landing";
    }

}
