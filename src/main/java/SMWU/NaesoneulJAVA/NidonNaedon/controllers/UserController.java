package SMWU.NaesoneulJAVA.NidonNaedon.controllers;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.UserDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/validateUser")
    public ResponseEntity<Boolean> validateUser(@RequestParam("kakaoId") String kakaoId) {
        boolean isValid = userService.validateUser(kakaoId);
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/users/nickname")
    public ResponseEntity<UserDTO> getUserNickname(@RequestParam("kakaoId") String kakaoId) {
        UserDTO userDTO = userService.getUserNickname(kakaoId);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/users/kakaoId")
    public ResponseEntity<String> getUserKakaoId(@RequestParam("userId") String userId) {
        String kakaoId = userService.getUserKakaoId(userId);
        return ResponseEntity.ok(kakaoId);
    }

    @PutMapping("/user/update")
    public ResponseEntity<Void> updateUser(
            @RequestParam("kakaoId") String kakaoId,
            @RequestParam("name") String name,
            @RequestParam("nickname") String nickname) {
        boolean success = userService.updateUserData(kakaoId, name, nickname);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
