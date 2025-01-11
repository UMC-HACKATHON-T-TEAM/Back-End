package UMC_Hackathon.DailyMate.domain;

import UMC_Hackathon.DailyMate.domain.common.BaseEntity;
import UMC_Hackathon.DailyMate.domain.enums.WeatherCondition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weather extends BaseEntity {
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
