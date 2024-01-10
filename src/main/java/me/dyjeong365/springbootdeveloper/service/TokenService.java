package me.dyjeong365.springbootdeveloper.service;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import me.dyjeong365.springbootdeveloper.config.jwt.TokenProvider;
import me.dyjeong365.springbootdeveloper.domain.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected Token");
        }
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }

}
