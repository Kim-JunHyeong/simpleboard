package com.examples.crazy.simpleboard.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "board_body")
@Getter @Setter @EqualsAndHashCode(of = "id")
public class BoardBody {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;
}
