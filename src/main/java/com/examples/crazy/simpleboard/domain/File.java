package com.examples.crazy.simpleboard.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "file")
@Getter @Setter @EqualsAndHashCode(of = "id")
public class File {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String storedFileName;

    private String contentType;

    private Integer size;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
