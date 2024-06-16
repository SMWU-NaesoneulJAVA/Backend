package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//추가
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class UserController {

    //추가
    

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User oauth2User) {
        System.out.println("User's Nickname: " + oauth2User.getAttribute("nickname"));
        System.out.println("User's Profile Image URL: " + oauth2User.getAttribute("profile_image"));
        String kakaoId = oauth2User.getAttributed("id");
        String name = oauth2User.getAttribute("name");
        String profile_image = oauth2User.getAttribute("profile");
        String nickname = oauth2User.getAttribute("nickname");

        User user = userService.findByKakaoId(kakaoId);
        if (user ==null){
            user = new User();
            user.setKakaoId(kakaoId);
            user.setName(name);
            user.setProfileImageUrl(profile_image);
            user.setNickname(nickname);
            userService.saveOrUpdateUser(user);
        }

        model.addAttribute("user",user);
        return "home";
    }

    @GetMapping("/oauth2/callback/kakao")
    public String callback() {
        return "redirect:/home";
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestParam("nickname") String nickname, @RequestParam("profileImageUrl") String profileImageUrl) {
        // 사용자 업데이트 로직을 여기에 추가합니다
        try {
            // 예시로, 실제로는 서비스 로직으로 업데이트합니다.
            System.out.println("Updating user: nickname=" + nickname + ", profileImageUrl=" + profileImageUrl);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
        }
    }
}
