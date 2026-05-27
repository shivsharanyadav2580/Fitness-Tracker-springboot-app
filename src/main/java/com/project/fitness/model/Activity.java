package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String , Object> attributes;



    @Enumerated(EnumType.STRING)
    private ActivityType type;
    private Integer duration;
    private Integer caloriesburned;
    private LocalDate startTime;
    private LocalDate creaedAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_activity"))
    private User user;

    @OneToMany(mappedBy = "activity")
    @JsonIgnore
    private List<Recommendation> recommendations = new ArrayList<>();

}
