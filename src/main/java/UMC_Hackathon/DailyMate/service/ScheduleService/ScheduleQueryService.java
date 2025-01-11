package UMC_Hackathon.DailyMate.service.ScheduleService;

import UMC_Hackathon.DailyMate.domain.Schedules;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

public interface ScheduleQueryService {
    @Transactional
    Page<Schedules> getScheduleList(Long userId, Integer page);

}
