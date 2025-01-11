package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.web.dto.RecommendResponseDTO;
import UMC_Hackathon.DailyMate.web.dto.ScheduleResponseDTO;

public class RecommendConverter {
    public static RecommendResponseDTO.RecommendResultDTO toRecommendResultDTO (String messageFortunePoint, String messageDateName, String recommend){
        return RecommendResponseDTO.RecommendResultDTO.builder()
                .fortunePoint(messageFortunePoint)
                .fortuneDate(messageDateName)
                .recommend(recommend)
                .build();
    }
}
