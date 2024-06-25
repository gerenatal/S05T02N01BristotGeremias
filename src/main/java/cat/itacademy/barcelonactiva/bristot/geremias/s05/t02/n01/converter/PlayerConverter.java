package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.converter;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public static Player DTOToDomain(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setId(playerDTO.getPlayer_id());
        player.setName(playerDTO.getName());
        player.setLocalDateTime(playerDTO.getLocalDateTime());
        return player;
    }

    public static PlayerDTO DomainToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setPlayer_id(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setLocalDateTime(player.getLocalDateTime());
        playerDTO.setSuccessRate(player.calculateSuccessRate());
        return playerDTO;
    }
}