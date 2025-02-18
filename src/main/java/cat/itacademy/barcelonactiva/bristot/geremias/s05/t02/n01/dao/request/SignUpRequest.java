package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String name;

    private String email;

    private String password;
}