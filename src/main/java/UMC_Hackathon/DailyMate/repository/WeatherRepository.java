package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.domain.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByUsers(Users users);

    @Query("SELECT w FROM Weather w where w.users = :user")
    List<Weather> findAllByUsers(@Param("user") Users user);
}
