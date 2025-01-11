package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.domain.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByUsers(Users users);
}
