package hofls.com.github.context.exclude.from.tests.controller;

import hofls.com.github.context.exclude.from.tests.service.BrokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// We dont need to test anything here, so exclude entire package
@Component
public class BrokenController {

    @Autowired
    private BrokenService service;

}
