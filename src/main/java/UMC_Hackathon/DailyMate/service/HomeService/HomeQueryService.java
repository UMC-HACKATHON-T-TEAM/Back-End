package UMC_Hackathon.DailyMate.service.HomeService;

import UMC_Hackathon.DailyMate.web.dto.HomeRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.HomeResponseDTO;
import jakarta.transaction.Transactional;

public interface HomeQueryService {
    @Transactional
    HomeResponseDTO.GetHomeResponseDTO getHome(Long userId, double lat, double lon);
}
