package com.examples.crazy.simpleboard.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "board")
@Getter @Setter @EqualsAndHashCode(of = "id", callSuper = false)
public class Board extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private Integer readCount;

    private Long parent_board_id;

    private Integer depth;

    private Integer replySeq;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_body_id")
    private BoardBody boardBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "board")
//    private Set<FileInfo> files = new HashSet<>();
}
