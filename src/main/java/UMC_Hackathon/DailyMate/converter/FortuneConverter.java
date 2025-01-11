package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.domain.Fortune;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.web.dto.ScheduleRequestDTO;

public class FortuneConverter {
    public static Fortune toFortune(Users user, String messageDateName, Integer point, String content, String color1, String color2, String item1, String item2){
        return Fortune.builder()
                .users(user)
                .dateName(messageDateName)
                .point(point)
                .content(content)
                .color1(color1)
                .color2(color2)
                .item1(item1)
                .item2(item2)
                .build();
    }
}
