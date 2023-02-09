package com.example.numbercheck;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wei.haothoughtworks.com
 */
@Component
@Service
public class NumberCheckService {

    public List<String> oddOrEven(List<Integer> numbers){
        return numbers.stream().map(this::checkNumberIsOddOrEven).collect(Collectors.toList());
    }
    public String checkNumberIsOddOrEven(Integer number) {
        if (number % 2 == 1) {
            return number +  " : is odd number";
        }
        return number + " : is even number";
    }
}
