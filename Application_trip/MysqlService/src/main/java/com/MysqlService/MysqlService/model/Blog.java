package com.MysqlService.MysqlService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonBackReference("Blog_User")
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;
    @JsonBackReference("Blog_Exp")
    @ManyToOne
    @JoinColumn(name = "explorer_id")
    private Explorer explorer;
    @JsonManagedReference("Blog_Trip")
    @OneToOne
    private Trip trip;
    @JsonManagedReference("Blog_Comment")
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();
}
