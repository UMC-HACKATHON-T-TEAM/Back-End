package UMC_Hackathon.DailyMate.service.UserService;

import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.converter.UserConverter;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.web.dto.UserRequestDTO;
import ch.qos.logback.core.status.ErrorStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Users joinUser(UserRequestDTO.JoinDto request) {

        Users newUser = UserConverter.toUser(request);
        newUser.setPassword(request.getPassword(), passwordEncoder); // 비밀번호 설정 (암호화 포함)

        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public Users authenticateUser(String email, String password) {
        // 이메일로 사용자 조회
        Users user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 비밀번호 검증
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }

    @Override
    @Transactional
    public Users EditOwnData(Long userId, UserRequestDTO.EditInfoDto request) {
        Users user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("사용자를 찾을 수 없습니다."));

        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setBirthday(Date.valueOf(request.getBirth()));

        return userRepository.save(user);
    }
}
