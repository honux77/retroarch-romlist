package net.honux.rpilist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class AppInitializer {

    @Autowired
    private DataUtils dataUtils;

    private Logger logger = LoggerFactory.getLogger(AppInitializer.class);

    @PostConstruct
    private void Init() {
        try {
            dataUtils.readXmlIntoDB(GameType.ARCADE);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            logger.debug(e.toString());
        }
    }
}
