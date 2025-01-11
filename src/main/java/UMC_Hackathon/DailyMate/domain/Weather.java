package UMC_Hackathon.DailyMate.domain;

import UMC_Hackathon.DailyMate.domain.enums.WeatherCondition;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column
    private WeatherCondition weatherCondition;

    private BigDecimal temperature;

    @Column(nullable = false, length = 50)
    private String region;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    public void setUsers(Users users) {
        this.users = users;
    }
}
