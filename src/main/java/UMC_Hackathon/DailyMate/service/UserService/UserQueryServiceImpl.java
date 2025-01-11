package UMC_Hackathon.DailyMate.service.UserService;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.web.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    @Override
    public Users getOwnData(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
