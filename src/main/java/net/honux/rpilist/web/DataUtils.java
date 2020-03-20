package net.honux.rpilist.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class DataUtils {

    private final static String romPath = "D:\\retropie";
    private final static Logger logger = LoggerFactory.getLogger(DataUtils.class);

    @Autowired
    private GameRepository gameRepository;

    public void readXmlIntoDB(GameType gameType) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(romPath + gameType.listFilename());

        Element root = document.getDocumentElement();
        //logger.debug("root node name: {}", root.getNodeName());

        //Get all employees
        NodeList gameList = document.getElementsByTagName("game");

        for (int i = 0; i < gameList.getLength(); i++) {
            Node node = gameList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Game game = createGameFromNode(node);
                gameRepository.save(game);
            }
        }
    }

    private Game createGameFromNode(Node gameNode) {
        Element game = (Element) gameNode;
        Game newGame = new Game(
                getElementTextStringFromGameNode(game, "path"),
                getElementTextStringFromGameNode(game, "name"),
                getElementTextStringFromGameNode(game, "desc"),
                getElementTextStringFromGameNode(game, "image"),
                getElementTextStringFromGameNode(game, "rating"),
                getElementTextStringFromGameNode(game, "releasedate"),
                getElementTextStringFromGameNode(game, "developer"),
                getElementTextStringFromGameNode(game, "publisher"),
                getElementTextStringFromGameNode(game, "genre"),
                getElementTextStringFromGameNode(game, "players"),
                getElementIntegerValueFromGameNode(game, "playcount"),
                getElementTextStringFromGameNode(game, "lastplayed")
        );
        logger.trace("From XML: {}", newGame);

        return newGame;
    }

    private Integer getElementIntegerValueFromGameNode(Element game, String tagName) {
        NodeList tag = game.getElementsByTagName(tagName);
        if (tag == null) return 0;
        if (tag.item(0) == null) return 0;
        return Integer.parseInt(tag.item(0).getTextContent());
    }

    ;

    private String getElementTextStringFromGameNode(Element game, String tagName) {
        NodeList tag = game.getElementsByTagName(tagName);
        if (tag == null) return "";
        if (tag.item(0) == null) return "";
        return tag.item(0).getTextContent();
    }
}
