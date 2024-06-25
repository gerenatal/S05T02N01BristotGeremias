package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.impl;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.converter.PlayerConverter;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.PlayerAlreadyExists;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.PlayerListIsEmpty;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.PlayerNotFound;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        if (playerDTO.getName() == null || playerDTO.getName().isBlank() || playerDTO.getName().equalsIgnoreCase("Unnamed")) {
            playerDTO.setName("Unnamed");
        } else if (playerRepository.existsByNameIgnoreCase(playerDTO.getName())) {
            throw new PlayerAlreadyExists();
        }
        return setNewPlayer(playerDTO);
    }

    private PlayerDTO setNewPlayer (PlayerDTO playerDTO){

        playerDTO.setName(playerDTO.getName());
        playerDTO.setLocalDateTime(LocalDateTime.now());
        Player player = PlayerConverter.DTOToDomain(playerDTO);
        playerRepository.save(player);
        return PlayerConverter.DomainToDTO(player);
    }

    @Override
    public PlayerDTO updatePlayer(Integer player_id, PlayerDTO newPlayerDTO) {
        Player playerToUpdate = findPlayerById(player_id);
        if (newPlayerDTO.getName() == null || newPlayerDTO.getName().isBlank()) {
            newPlayerDTO.setName("Unnamed");
        } else if (playerRepository.existsByNameIgnoreCase(newPlayerDTO.getName())) {
            throw new PlayerAlreadyExists();
        }
        playerToUpdate.setName(newPlayerDTO.getName());
        playerRepository.save(playerToUpdate);
        return PlayerConverter.DomainToDTO(playerToUpdate);

    }

    @Override
    public List<PlayerDTO> getAllPlayers() {

        List<Player> playerList = playerRepository.findAll();
        if (playerList.isEmpty()) {
            throw new PlayerListIsEmpty();
        }
        return playerList.stream().map(PlayerConverter::DomainToDTO)
                .collect(Collectors.toList());
    }


    public Player findPlayerById(int playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(PlayerNotFound::new);
    }

}
