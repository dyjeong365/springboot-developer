package me.dyjeong365.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.dyjeong365.springbootdeveloper.config.jwt.TokenProvider;
import me.dyjeong365.springbootdeveloper.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofDays(2));
    }
}
