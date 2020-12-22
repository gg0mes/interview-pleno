package br.com.brainweb.interview.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("healthCheck")
@RequiredArgsConstructor
@CrossOrigin
public class HealthCheckController {

    @GetMapping
    public @ResponseBody String healthCheck() throws Exception{
        return "Ok";
    }

}
