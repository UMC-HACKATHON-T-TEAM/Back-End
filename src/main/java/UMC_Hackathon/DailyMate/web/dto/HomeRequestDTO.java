package UMC_Hackathon.DailyMate.web.dto;


import lombok.Getter;

public class HomeRequestDTO {
    @Getter
    public static class Coord{
        double lat;
        double lon;
    }
}
