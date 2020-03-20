package net.honux.rpilist.web;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GameMachineRepository extends CrudRepository<GameMachine, Long> {

    @Query("SELECT * FROM game_machine WHERE type = :type")
    Optional<GameMachine> findByType(@Param("type") String typeString);
}
