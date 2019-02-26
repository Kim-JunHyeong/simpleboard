package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Role;
import com.examples.crazy.simpleboard.domain.constant.MemberRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void getRole() {
        Set<Role> byName = roleRepository.findByName(MemberRole.USER);
        byName.forEach(byRole -> {
            System.out.println(byRole.getName());
        });
    }
}