package com.cripstian.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
class UpdateController {
    private static final Log LOG = LogFactory.getLog(UpdateController.class);

    @PostMapping("/update")
    public String updateWithNewValue(@RequestParam("youtube-url") final String youtubeUrl) {
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("killall firefox");
            runtime.exec("firefox -new-window " + youtubeUrl);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "redirect:home";
    }

}
