package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
