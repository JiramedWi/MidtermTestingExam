package Problem2;

import Problem1.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.closeTo;

class memberServiceTest {

    @Test
    void calculateDiscountForPlatinum() {
        memberService memberService = new memberService();
        assertThat(memberService.calculateDiscount(1, 20000.00), is(
                closeTo(18000.00, 0.001)));
        assertThat(memberService.calculateDiscount(1, 50000.00), is(
                closeTo(42500.00, 0.001)));
        assertThat(memberService.calculateDiscount(1, 100000.00), is(
                closeTo(80000.00, 0.001)));
    }

    @Test
    void calculateDiscountForWhite() {
        memberService memberService = new memberService();
        assertThat(memberService.calculateDiscount(2, 20000.00), is(
                closeTo(19400.00, 0.001)));
        assertThat(memberService.calculateDiscount(2, 50000.00), is(
                closeTo(47500.00, 0.001)));
        assertThat(memberService.calculateDiscount(2, 100000.00), is(
                closeTo(90000.00, 0.001)));
    }

    @Test
    void typeIsNot1Or2() {
        memberService memberService = new memberService();
        Assertions.assertThrows(NoMemberTypeException.class, () -> {
            memberService.calculateDiscount(3, 10000.0);
        });
    }

    @Test
    void priceIsNegative() {
        memberService memberService = new memberService();
        Assertions.assertThrows(PriceCannotBeNegativeException.class, () -> {
            memberService.calculateDiscount(1, -10000.0);
        });
    }
}