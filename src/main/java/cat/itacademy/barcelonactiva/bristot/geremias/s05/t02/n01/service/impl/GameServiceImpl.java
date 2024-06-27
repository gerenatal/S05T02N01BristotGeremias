package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.impl;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.converter.GameConverter;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Game;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.GameDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.GameNotFoundException;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository.GameRepository;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.GameService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerServiceImpl playerService;

    @Transactional
    @Override
    public GameDTO addGame(Integer player_id) {
        Player player = playerService.findPlayerById(player_id);

        Game newGame = new Game();
        newGame.setPlayer(player);
        rollDice(newGame);
        newGame.setLocalDate(LocalDate.now()); // Change that
        player.addGame(newGame);
        gameRepository.save(newGame);

        return GameConverter.DomainToDTO(newGame);
    }

    private void rollDice (Game game){
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWin(game.isWin());
    }

    @Transactional
    @Override
    public List<GameDTO> getAllGames(Integer player_id) {
        Player player = playerService.findPlayerById(player_id);
        List<Game> games = gameRepository.findByPlayer_id(player.getId());
        if(games==null || games.isEmpty()){
            throw new GameNotFoundException();
        }
        return games.stream().map(GameConverter::DomainToDTO).collect(Collectors.toList());
    }
    @Transactional
    public void deleteAllGames (Integer player_id) {
        Player player = playerService.findPlayerById(player_id);
        List<Game> games = player.getListOfGames();
        if(games==null || games.isEmpty()){
            throw new GameNotFoundException();
        }
        games.clear();
        gameRepository.deleteByPlayer_id(player.getId());
    }
}
