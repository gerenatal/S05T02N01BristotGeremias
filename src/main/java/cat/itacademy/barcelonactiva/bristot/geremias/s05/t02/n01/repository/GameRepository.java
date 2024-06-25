package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByPlayer_id (Integer player_id);
    void deleteByPlayer_id(Integer player_id);
}