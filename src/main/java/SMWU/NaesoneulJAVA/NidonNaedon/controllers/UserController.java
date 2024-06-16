package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController  // @Controller 대신 @RestController 사용
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User oauth2User) {
        System.out.println("User's Name: " + oauth2User.getAttribute("name"));
        return "home";
    }

    @GetMapping("/oauth2/callback/kakao")
    public String callback() {
        return "redirect:/home";
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestParam("name") String name, @RequestParam("nickname") String nickname) {
        // 사용자 업데이트 로직을 여기에 추가합니다
        try {
            // 예시로, 실제로는 서비스 로직으로 업데이트합니다.
            System.out.println("Updating user: " + name + ", nickname: " + nickname);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
        }
    }
}
