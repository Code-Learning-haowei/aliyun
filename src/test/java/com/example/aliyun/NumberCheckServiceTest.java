package com.example.aliyun;

import com.example.aliyun.service.NumberCheckService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberCheckServiceTest {

    NumberCheckService numberCheckService = new NumberCheckService();

    @Test
    void checkNumberIsOddOrEven() {
        List<Integer> numbers = List.of(5, 10, 15, 20);
        List<String> oddOrEvenStrings = numberCheckService.oddOrEven(numbers);
        List<String> exceptStrings = List.of("5 : is odd number", "10 : is even number", "15 : is odd number", "20 : is even number");

        assertEquals(exceptStrings, oddOrEvenStrings);
    }
}