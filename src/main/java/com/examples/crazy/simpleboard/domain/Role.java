package com.examples.crazy.simpleboard.domain;

import com.examples.crazy.simpleboard.domain.constant.MemberRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "role")
@Getter @Setter @EqualsAndHashCode(of = "id")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private MemberRole name;
}
