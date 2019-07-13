package com.sda;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoTest {

    // BDD - behavior driven design
    @Test
    public void givenState_whenMethodUnderTest_thenExpectedResult() {

        // given - the required objects
        MyObject objectWithTestMethods = new MyObject();
        String expected = "it works!";

        // when - test some method
        String actual = objectWithTestMethods.methodUnderTest();

        // then - check that actual equals expected
        assertThat(actual).isEqualTo(expected);
        // this resolves to true only if methodUnderTest() returns "it works!"
    }
}
