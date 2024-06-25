package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.converter;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Game;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.GameDTO;
import org.springframework.stereotype.Component;

@Component
public class GameConverter {

    public static GameDTO DomainToDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGame_id(game.getGame_id());
        gameDTO.setDice1(game.getDice1());
        gameDTO.setDice2(game.getDice2());
        gameDTO.setWin(game.isWin());
        return gameDTO;
    }
}