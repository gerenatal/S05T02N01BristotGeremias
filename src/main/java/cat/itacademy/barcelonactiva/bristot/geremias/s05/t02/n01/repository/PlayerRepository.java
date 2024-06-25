package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Optional<Player> findByName (String name);
    boolean existsByNameIgnoreCase(String name);
}