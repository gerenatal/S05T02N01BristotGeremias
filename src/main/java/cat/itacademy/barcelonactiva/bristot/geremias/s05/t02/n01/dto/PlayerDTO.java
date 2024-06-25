package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private Integer player_id;
    private String name;
    private LocalDateTime localDateTime;
    private float successRate;
}
