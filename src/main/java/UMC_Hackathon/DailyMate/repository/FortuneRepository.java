package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Fortune;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FortuneRepository extends JpaRepository<Fortune, Long> {
    Fortune findByUsers(Users users);
    @Transactional
    void deleteByUsers(Users users);
}
