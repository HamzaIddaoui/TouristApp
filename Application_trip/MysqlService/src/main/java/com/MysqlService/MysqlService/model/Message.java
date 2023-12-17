package com.MysqlService.MysqlService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Timestamp time;
    @OneToOne(mappedBy = "message",cascade = CascadeType.ALL, orphanRemoval = true)
    private ResponseMessage responseMessage;
    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;

}
