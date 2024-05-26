package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthController {

    @GetMapping("/secure-endpoint")
    public ResponseEntity<String> secureEndpoint(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authorizationHeader) {
        System.out.println("Authorization Header: " + authorizationHeader); // Debugging line
        if (authorizationHeader == null || !isValidToken(authorizationHeader)) {
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"myRealm\"");
            return new ResponseEntity<>("Unauthorized", headers, HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok("You have accessed the secure endpoint!");
    }

    private boolean isValidToken(String token) {
        try {
            String credentials = token.replace("Basic ", "");
            String decodedCredentials = new String(Base64.getDecoder().decode(credentials));
            System.out.println("Decoded Credentials: " + decodedCredentials); // Debugging line
            return "user:password".equals(decodedCredentials);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Base64 token: " + token);
            return false;
        }
    }
}
