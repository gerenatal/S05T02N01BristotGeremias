package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);
}
