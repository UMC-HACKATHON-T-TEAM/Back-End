package UMC_Hackathon.DailyMate.service.UserService;

import UMC_Hackathon.DailyMate.domain.Users;

public interface UserQueryService {
    public Users getOwnData(Long userId);
}
