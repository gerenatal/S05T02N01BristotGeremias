package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.impl;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.converter.PlayerConverter;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.PlayerListIsEmpty;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public double getAveragePlayer (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerListIsEmpty();
        }
        double totalSuccessRate = players.stream()
                .mapToDouble(Player::calculateSuccessRate)
                .sum();
        return Math.round(totalSuccessRate / players.size());
    }

    @Override
    public PlayerDTO getWinnerPlayer (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerListIsEmpty();
        }
        Player winner = players.stream().max(Comparator.comparing(Player::calculateSuccessRate))
                .orElse(null);
        return PlayerConverter.DomainToDTO(winner);
    }

    @Override
    public PlayerDTO getLoserPlayer (){
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()){
            throw new PlayerListIsEmpty();
        }
        Player loser = players.stream().min(Comparator.comparing(Player::calculateSuccessRate))
                .orElse(null);
        return PlayerConverter.DomainToDTO(loser);
    }
}
