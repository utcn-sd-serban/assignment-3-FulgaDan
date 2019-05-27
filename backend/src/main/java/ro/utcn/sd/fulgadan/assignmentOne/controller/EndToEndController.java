package ro.utcn.sd.fulgadan.assignmentOne.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.fulgadan.assignmentOne.seed.ApplicationSeed;

@Profile("e2e")
@RestController
@RequiredArgsConstructor
public class EndToEndController {
    private final ApplicationSeed applicationSeed;

    @RequestMapping("test/reseed")
    public void reSeed(){
        //clear all and then run
    }
}
