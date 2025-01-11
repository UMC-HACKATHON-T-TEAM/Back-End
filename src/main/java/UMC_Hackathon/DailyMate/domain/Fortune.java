package UMC_Hackathon.DailyMate.domain;

import UMC_Hackathon.DailyMate.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Fortune extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 10)
    private String dateName;

    private Integer point;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String color1;

    @Column(columnDefinition = "TEXT")
    private String color2;

    @Column(columnDefinition = "TEXT")
    private String item1;

    @Column(columnDefinition = "TEXT")
    private String item2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    public void setUsers(Users users) {
        this.users = users;
    }
}
