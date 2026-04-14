package com.example.demo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Map;

@Controller// We cant use RestController because it return data(string/json) but controller support redirect.  
@RequestMapping("/auth/google")
public class GoogleAuthController {

    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.secret}")
    private String clientSecret;

    @Value("${google.redirect.uri}")
    private String redirectUri;

    private final WebClient webClient = WebClient.create();

    @GetMapping("/login")
    public void redirectToGoogle(HttpServletResponse response) throws IOException {

        String url = "https://accounts.google.com/o/oauth2/v2/auth" +
                "?client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&response_type=code" +
                "&scope=openid%20profile%20email";

        response.sendRedirect(url);
    }

    @GetMapping("/callback")
    public String handleCallback(@RequestParam String code) {

        System.out.println("Code received: " + code);

        // STEP 1: Exchange code → access token
        Map tokenResponse = webClient.post()
                .uri("https://oauth2.googleapis.com/token")
                .bodyValue(Map.of(
                        "client_id", clientId,
                        "client_secret", clientSecret,
                        "code", code,
                        "grant_type", "authorization_code",
                        "redirect_uri", redirectUri
                ))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        String accessToken = (String) tokenResponse.get("access_token");

        Map userInfo = webClient.get()
                .uri("https://www.googleapis.com/oauth2/v2/userinfo")
                .headers(headers -> headers.setBearerAuth(accessToken))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        String email = (String) userInfo.get("email");
        String name = (String) userInfo.get("name");

        String jwt = "jwt-token-for-" + email;

        return "redirect:http://localhost:5173/home?token=" + jwt;
    }
}