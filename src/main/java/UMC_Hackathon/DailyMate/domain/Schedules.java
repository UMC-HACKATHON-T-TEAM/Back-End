package UMC_Hackathon.DailyMate.domain;

import UMC_Hackathon.DailyMate.domain.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Schedules extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDate date;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    public void setUsers(Users users) {
        // 기존에 이미 등록되어 있던 관계를 제거
        if (this.users != null) {
            this.users.getSchedulesList().remove(this);
        }

        this.users = users;

        // 양방향 관계를 설정
        if (users != null) {
            users.getSchedulesList().add(this);
        }
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
