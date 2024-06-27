package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request.SignUpRequest;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request.SigninRequest;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.response.JwtAuthenticationResponse;

public interface AuthService {
    JwtAuthenticationResponse signin(SigninRequest request);
    JwtAuthenticationResponse signup(SignUpRequest request);
}
