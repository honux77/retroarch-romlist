package net.honux.rpilist.web;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class GameMachineRepositoryTest {

    @Autowired
    private GameMachineRepository repo;

    private Logger logger = LoggerFactory.getLogger(GameMachineRepositoryTest.class);

    @Test
    void repoCrudTest() {

        if(repo.count() == 0) {
            GameMachine m = new GameMachine(GameType.ARCADE);
            repo.save(m);
            logger.info("Insert: {}", m);
            assertThat(m.getId()).isNotNull();
        } else
        {
            logger.info("Current Item in Machine repo: {}", repo.count());

        }

        //findById
        Optional<GameMachine> machineOptional = repo.findById(1L);
        assertThat(machineOptional.isPresent()).isTrue();
        logger.info("FindById: {}, count: {}", machineOptional.get(), repo.count());

        //findByType
        machineOptional = repo.findByType(GameType.ARCADE.name());
        assertThat(machineOptional.isPresent()).isTrue();
        logger.info("FindByType: {}, count: {}", machineOptional.get(), repo.count());
    }
}