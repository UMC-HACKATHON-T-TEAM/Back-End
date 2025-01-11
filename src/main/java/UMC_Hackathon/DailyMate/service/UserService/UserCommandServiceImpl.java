package UMC_Hackathon.DailyMate.service.UserService;

import UMC_Hackathon.DailyMate.converter.UserConverter;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.web.dto.UserRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Users joinUser(UserRequestDTO.JoinDto request) {

        Users newUser = UserConverter.toUser(request);
        // 비밀번호 설정 (암호화 포함)
        newUser.setPassword(request.getPassword(), passwordEncoder);

        return userRepository.save(newUser);
    }
}
