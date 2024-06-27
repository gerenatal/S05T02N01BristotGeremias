package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.impl;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request.SignUpRequest;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.request.SigninRequest;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.dao.response.JwtAuthenticationResponse;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.Role;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.domain.User;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.EmailAlreadyExistsException;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception.SignupInvalidException;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.repository.UserRepository;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.AuthService;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException();
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role((request.getName().startsWith("admin") ? Role.ADMIN : Role.USER))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                ));
        var user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(SignupInvalidException::new);
        var jwtToken = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwtToken).build();
    }
}
