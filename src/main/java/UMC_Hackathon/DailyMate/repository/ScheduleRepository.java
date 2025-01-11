package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
    Page<Schedules> findAllByUser(Users users, PageRequest pageRequest);
}
