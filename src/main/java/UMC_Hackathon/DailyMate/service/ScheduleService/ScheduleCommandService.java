package UMC_Hackathon.DailyMate.service.ScheduleService;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.web.dto.ScheduleRequestDTO;
import jakarta.transaction.Transactional;

public interface ScheduleCommandService {
    @Transactional
    Schedules createSchedule(ScheduleRequestDTO.ScheduleDto request, Long userId);

    @Transactional
    void deleteSchedule(Long scheduleId);

    @Transactional
    Schedules updateSchedule(ScheduleRequestDTO.ScheduleUpdateRequestDto request, Long userId, Long scheduleId);
}
