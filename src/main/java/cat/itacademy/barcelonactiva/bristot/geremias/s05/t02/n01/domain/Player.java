package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private LocalDateTime localDateTime;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Game> listOfGames;

    public void addGame (Game game){
        if(listOfGames == null){
            listOfGames = new ArrayList<>();
        }
        listOfGames.add(game);
        game.setPlayer(this);
    }

    public float calculateSuccessRate (){
        if(listOfGames != null && !listOfGames.isEmpty()){
            long totalGames = listOfGames.size();
            long wonGames = listOfGames.stream().filter(Game::winMethod).count();
            return (float) wonGames/totalGames * 100;
        }
        return 0.0f;
    }
}
