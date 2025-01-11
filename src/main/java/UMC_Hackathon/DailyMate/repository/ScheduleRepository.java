package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
    Page<Schedules> findAllByUsers(Users users, PageRequest pageRequest);

    @Query("SELECT s FROM Schedules s where s.users = :user")
    List<Schedules> getSchedulesByUser(Users user);
}
