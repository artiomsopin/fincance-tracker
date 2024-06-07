package fincances.fincancetracker.service.userService;

import fincances.fincancetracker.entity.UserEntity;
import fincances.fincancetracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return this.userRepository.save(user);
    }

    @Override
    public Long getBalanceByUserId(Long userId) {
        Optional<UserEntity> user = this.userRepository.findById(userId);
        return user.get().getBalance();
    }

    @Override
    public void deleteUserById(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public UserEntity updateUserById(Long userId, UserEntity user) throws Exception {
        Optional<UserEntity> userEntity = this.userRepository.findById(userId);

        if (userEntity.isPresent()) {
            // Get user from optional wrapper
            UserEntity userEntityToUpdate = userEntity.get();

            // Set new data to provided fields
            userEntityToUpdate.setUsername(user.getUsername());
            userEntityToUpdate.setPassword(user.getPassword());
            userEntityToUpdate.setBalance(user.getBalance());

            return this.userRepository.save(userEntityToUpdate);
        } else {
            throw new Exception("User not found");
        }
    }
}
