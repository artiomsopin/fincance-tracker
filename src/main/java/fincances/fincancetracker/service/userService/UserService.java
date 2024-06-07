package fincances.fincancetracker.service.userService;

import fincances.fincancetracker.entity.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity user);
    Long getBalanceByUserId(Long userId);
    void deleteUserById(Long userId);
    UserEntity updateUserById(Long userId, UserEntity user) throws Exception;
}
