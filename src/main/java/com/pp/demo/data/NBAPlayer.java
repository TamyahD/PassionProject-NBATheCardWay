package com.pp.demo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name ="nbaPlayers")
public class NBAPlayer implements Serializable {
    @Id
    @Column(name="player_id", insertable=false, updatable=false)
    private Integer id;

    @Column(name ="first_name")
    private String first_name;
//    private String firstName;

    @Column(name ="last_name")
    private String last_name;
//    private String lastName;

    @Column(name ="position")
    private String position;

    public enum Position {
        G, F, C
    }

    public NBAPlayer() {}

    @JsonIgnore
    @AlwaysNull
    private String height_feet;
    @JsonIgnore
    @AlwaysNull
    private String height_inches;
    @Embedded
    private Team team;
    @JsonIgnore
    @AlwaysNull
    private String weight_pounds;
}
