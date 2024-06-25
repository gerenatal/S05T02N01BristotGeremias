package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;

public interface RankingService {
    double getAveragePlayer ();
    PlayerDTO getWinnerPlayer ();
    PlayerDTO getLoserPlayer ();
}