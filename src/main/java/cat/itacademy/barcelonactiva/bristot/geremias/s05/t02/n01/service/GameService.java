package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO addGame (Integer id);
    void deleteAllGames (Integer id);
    List<GameDTO> getAllGames (Integer id);
}