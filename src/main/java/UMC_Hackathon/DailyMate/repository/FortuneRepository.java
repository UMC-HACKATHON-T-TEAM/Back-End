package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Fortune;
import UMC_Hackathon.DailyMate.domain.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FortuneRepository extends JpaRepository<Fortune, Long> {
}
