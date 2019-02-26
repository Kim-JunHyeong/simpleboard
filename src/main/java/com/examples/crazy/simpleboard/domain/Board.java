package com.examples.crazy.simpleboard.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "board")
@Getter @Setter @EqualsAndHashCode(of = "id", callSuper = false)
public class Board extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "int default 0")
    private int readCount;

    private Long parent_board_id;

    @Column(columnDefinition = "int default 0")
    private int depth;

    @Column(columnDefinition = "int default 0")
    private int replySeq;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_body_id")
    private BoardBody boardBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private Set<FileInfo> files = new HashSet<>();

    @OneToMany(mappedBy = "board")
    private Set<Comment> comments = new HashSet<>();
}
