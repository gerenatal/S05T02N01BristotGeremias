package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request.SignUpRequest;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request.SigninRequest;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.response.JwtAuthenticationResponse;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity <JwtAuthenticationResponse> signup (@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }

    @PostMapping ("/signin")
    public ResponseEntity <JwtAuthenticationResponse> signin (@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authService.signin(signinRequest));
    }
}
