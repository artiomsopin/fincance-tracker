package fincances.fincancetracker.controller;

import fincances.fincancetracker.entity.UserEntity;
import fincances.fincancetracker.service.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/get/balance")
    public ResponseEntity getBalanceByUserId(@RequestParam("id") Long userId) {
        try {
            return ResponseEntity.ok(this.userService.getBalanceByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam("id") Long userId) {
        try {
            this.userService.deleteUserById(userId);
            return ResponseEntity.ok().body("User successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestParam("id") Long userId, @RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok().body(this.userService.updateUserById(userId, user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
