package net.honux.rpilist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class AppInitializer {

    @Autowired
    private DataUtils dataUtils;

    @Autowired
    private GameMachineRepository machineRepository;

    private Logger logger = LoggerFactory.getLogger(AppInitializer.class);

    @PostConstruct
    private void Init() {
        logger.info("App Initializer start.");
    }
//        try {
//            logger.info("Start to insert Game list into H2 DB");
//            for (GameType type: GameType.values()) {
//                GameMachine machine = new GameMachine(type);
//                machineRepository.save(machine);
//                dataUtils.readXmlIntoDB(GameType.ARCADE);
//
//            }
//            logger.info("Finish DB Convert");
//
//        } catch (ParserConfigurationException | IOException | SAXException e) {
//            logger.debug(e.toString());
//        }
//    }
}
