package UMC_Hackathon.DailyMate.service.ScheduleService;

import UMC_Hackathon.DailyMate.apiPayload.ApiResponse;
import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.ScheduleHandler;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.converter.ScheduleConverter;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.web.dto.ScheduleRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleCommandServiceImpl implements ScheduleCommandService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Schedules createSchedule(ScheduleRequestDTO.ScheduleDto request, Long userId) {

        Users users = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Schedules newSchedule = ScheduleConverter.toScheduleDTO(request, users);

        return scheduleRepository.save(newSchedule);
    }

    @Override
    @Transactional
    public void deleteSchedule(Long scheduleId) {
        // 일정이 존재하지 않을 경우 예외 발생
        Schedules schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 일정 아이디: " + scheduleId));

        // 삭제 작업 수행
        scheduleRepository.delete(schedule);
    }

    @Override
    @Transactional
    public Schedules updateSchedule(ScheduleRequestDTO.ScheduleUpdateRequestDto request, Long userId, Long scheduleId) {


        Users users = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Schedules schedules = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleHandler(ErrorStatus.SCHEDULE_NOT_FOUND));

        ScheduleConverter.toScheduleUpdateResultDTO(request, users, schedules);
        return schedules;

    }


}
