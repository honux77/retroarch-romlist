package net.honux.rpilist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class ApiGameController {

    @Autowired
    private DataUtils utils;

    @GetMapping("hello")
    public SimpleResult hello() {
        return new SimpleResult("ok", "hello");
    }

    @GetMapping("init")
    public SimpleResult init() {
        try {
            utils.readXmlIntoDB(GameType.ARCADE);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return new SimpleResult("ok", "okok");
    }
}
