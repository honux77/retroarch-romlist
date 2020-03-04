package net.honux.rpilist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ApiGameController {

    @GetMapping("hello")
    public SimpleResult hello() {
        return new SimpleResult("ok", "hello");
    }
}
