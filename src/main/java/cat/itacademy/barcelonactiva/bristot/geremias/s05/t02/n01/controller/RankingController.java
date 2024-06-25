package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping("/ranking")
    public ResponseEntity<?> getAveragePlayer (){
        Double successAverage = rankingService.getAveragePlayer();
        return new ResponseEntity<>(successAverage, HttpStatus.OK);
    }

    @GetMapping("/ranking/winner")
    public ResponseEntity<?> getWinnerPlayer (){
        PlayerDTO winner = rankingService.getWinnerPlayer();
        return new ResponseEntity<>(winner, HttpStatus.OK);
    }

    @GetMapping("/ranking/loser")
    public ResponseEntity<?> getLoserPlayer (){
        PlayerDTO loser = rankingService.getLoserPlayer();
        return new ResponseEntity<>(loser, HttpStatus.OK);
    }
}
