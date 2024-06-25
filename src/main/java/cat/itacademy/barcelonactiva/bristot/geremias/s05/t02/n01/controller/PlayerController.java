package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO newPlayer = playerService.addPlayer(playerDTO);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable("id") int id, @RequestBody PlayerDTO playerDTO) {
        PlayerDTO playerUpdate = playerService.updatePlayer(id, playerDTO);
        return new ResponseEntity<>(playerUpdate, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPlayers() {
        List<PlayerDTO> searchedPlayer = playerService.getAllPlayers();
        return ResponseEntity.status(HttpStatus.FOUND).body(searchedPlayer);

    }
}
