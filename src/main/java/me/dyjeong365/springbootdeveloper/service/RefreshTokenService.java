package me.dyjeong365.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.dyjeong365.springbootdeveloper.domain.RefreshToken;
import me.dyjeong365.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
