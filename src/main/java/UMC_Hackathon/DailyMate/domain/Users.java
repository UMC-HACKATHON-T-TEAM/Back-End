package UMC_Hackathon.DailyMate.domain;

import UMC_Hackathon.DailyMate.domain.common.BaseEntity;
import UMC_Hackathon.DailyMate.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users extends BaseEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    private String birthday;

    @Enumerated(EnumType.STRING)
    @Column
    private UserStatus status;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Schedules> schedulesList = new ArrayList<>();

    public void setPassword(String rawPassword, PasswordEncoder passwordEncoder) {
        // 비밀번호를 암호화한 후 저장
        this.password = passwordEncoder.encode(rawPassword);
    }

    public void encodePassword(String password) {
        this.password = password;
    }
}
