package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO addPlayer(PlayerDTO playerDTO);
    PlayerDTO updatePlayer (Integer id, PlayerDTO playerDTO);
    List<PlayerDTO> getAllPlayers();
}
