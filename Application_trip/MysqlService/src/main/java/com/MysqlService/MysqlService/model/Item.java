package com.MysqlService.MysqlService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float prix;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
