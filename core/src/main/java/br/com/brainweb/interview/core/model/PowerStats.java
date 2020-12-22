package br.com.brainweb.interview.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerStats implements Serializable {

    @Id
    private String uuid;

    private int strength;

    private int agility;

    private int dexterity;

    private int intelligence;

    private Date created_at;

    private Date updated_at;

}
