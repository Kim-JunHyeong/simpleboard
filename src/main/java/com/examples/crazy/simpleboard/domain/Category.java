package com.examples.crazy.simpleboard.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity @Table(name = "category")
@Getter @Setter @EqualsAndHashCode(of = "id")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

//    @OneToMany(mappedBy = "category")
//    private Set<Board> boards;
}
