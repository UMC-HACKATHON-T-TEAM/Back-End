package UMC_Hackathon.DailyMate.service.ScheduleService;

import UMC_Hackathon.DailyMate.domain.Schedules;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ScheduleQueryService {
    @Transactional
    List<Schedules> getSchedulesList(Long userId);

}
