package UMC_Hackathon.DailyMate.service.ScheduleService;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public List<Schedules> getSchedulesList(Long userId) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        List<Schedules> userSchedules = scheduleRepository.getSchedulesByUser(users);
        return userSchedules;
    }
}
