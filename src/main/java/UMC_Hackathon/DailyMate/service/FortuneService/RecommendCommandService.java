package UMC_Hackathon.DailyMate.service.FortuneService;

import UMC_Hackathon.DailyMate.web.dto.RecommendRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.RecommendResponseDTO;

public interface RecommendCommandService {
    RecommendResponseDTO.RecommendResultDTO CreandRecommendAndPostFortune(RecommendRequestDTO.CreateRecommendAndPostFortuneRequestDTO request);
}
