package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUser() {
        User user = userRepository.findByLoginId("kjh4685");

        System.out.println(user.getAlias());
    }

}