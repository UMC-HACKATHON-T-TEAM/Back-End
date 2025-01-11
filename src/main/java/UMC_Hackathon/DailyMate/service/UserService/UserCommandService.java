package UMC_Hackathon.DailyMate.service.UserService;

import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.web.dto.UserRequestDTO;

public interface UserCommandService {
    Users joinUser(UserRequestDTO.JoinDto request);
}
