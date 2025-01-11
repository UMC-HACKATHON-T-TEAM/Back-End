package UMC_Hackathon.DailyMate.service.RecommendService;

import UMC_Hackathon.DailyMate.domain.Fortune;
import UMC_Hackathon.DailyMate.web.dto.RecommendRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.RecommendResponseDTO;

public interface RecommendCommandService {
    RecommendResponseDTO.RecommendResultDTO CreateRecommendAndPostFortune(RecommendRequestDTO.CreateRecommendAndPostFortuneRequestDTO request);
    Fortune GetFortune(Long userId);
}
