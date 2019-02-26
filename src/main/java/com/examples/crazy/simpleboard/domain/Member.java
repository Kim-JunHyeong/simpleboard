package com.examples.crazy.simpleboard.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "member")
@Getter @Setter @EqualsAndHashCode(of = "id")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false, unique = true)
    private String alias;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

//    @OneToMany(mappedBy = "member")
//    private Set<Board> boards;

//    @OneToMany(mappedBy = "member")
//    private Set<Comment> comments;
}
