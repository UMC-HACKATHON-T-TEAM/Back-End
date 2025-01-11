package UMC_Hackathon.DailyMate.service.ScheduleService;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleQueryServiceImpl implements  ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;

    private final UserRepository userRepository;


    @Override
    public Page<Schedules> getScheduleList(Long userId, Integer page) {

        Users users = userRepository.findById(userId) .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Page<Schedules> userPage = scheduleRepository.findAllByUsers(users, PageRequest.of(page, 10));

        return userPage;
    }
}
