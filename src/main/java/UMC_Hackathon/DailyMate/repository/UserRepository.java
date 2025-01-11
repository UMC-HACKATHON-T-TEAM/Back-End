package UMC_Hackathon.DailyMate.repository;

import UMC_Hackathon.DailyMate.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
