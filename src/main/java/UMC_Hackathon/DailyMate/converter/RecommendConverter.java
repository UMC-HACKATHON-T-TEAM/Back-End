package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.domain.Fortune;
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
    public static RecommendResponseDTO.FortuneResultDTO toFortuneResultDTO (Fortune fortune){
        return RecommendResponseDTO.FortuneResultDTO.builder()
                .point(fortune.getPoint())
                .content(fortune.getContent())
                .color1(fortune.getColor1())
                .color1HexCode(fortune.getColor1HexCode())
                .color2(fortune.getColor2())
                .color2HexCode(fortune.getColor2HexCode())
                .item1(fortune.getItem1())
                .item2(fortune.getItem2())
                .build();
    }
}
