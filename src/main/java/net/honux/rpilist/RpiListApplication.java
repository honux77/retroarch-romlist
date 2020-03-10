package net.honux.rpilist;

import net.honux.rpilist.web.GameType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;

import static net.honux.rpilist.web.DataUtils.readXmlIntoDB;


@SpringBootApplication
public class RpiListApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpiListApplication.class, args);
		try {
			readXmlIntoDB(GameType.ARCADE);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}
	}

}
