package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT m FROM Member m JOIN FETCH m.roles WHERE m.loginId = :loginId")
    Member findByLoginId(@Param("loginId") String loginId);
}
