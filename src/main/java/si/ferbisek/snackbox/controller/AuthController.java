package si.ferbisek.snackbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.ferbisek.snackbox.dto.AuthResponse;
import si.ferbisek.snackbox.dto.LoginRequest;
import si.ferbisek.snackbox.service.AuthenticationService;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        String tokenValue = authenticationService.generateToken(userDetails);

        int TWENTY_FOUR_HOURS_IN_SECONDS = 86400;
        AuthResponse authResponse = AuthResponse.builder()
                .token(tokenValue)
                .expiresIn(TWENTY_FOUR_HOURS_IN_SECONDS)
                .build();

        return ResponseEntity.ok(authResponse);
    }
}
