package com.examples.crazy.simpleboard.security;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PasswordEncodeTest {

    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    public void passwordEncoder() {
        String encoder = passwordEncoder.encode("1234");
        System.out.println(encoder);

        boolean matches = passwordEncoder.matches("1234", "{bcrypt}$2a$10$tgJYSm768my7yKl/nTTFquRHoPCN84HDzsHEKCURslksDDCF6QEXy");
        assertThat(matches).isTrue();
    }
}
