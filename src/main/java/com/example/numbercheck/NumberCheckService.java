package com.example.numbercheck;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public Map<String, DemoClass> demo(List<DemoClass> demoClassList) {
        return demoClassList.stream().collect(Collectors.toMap(DemoClass::getKeyNo, Function.identity()));
    }

    public void runDemo() {
        List<DemoClass> demoList= new ArrayList<>();
        demoList.add(new DemoClass("key1", "val1"));
        demoList.add(new DemoClass("key2", "val2"));
        demoList.add(new DemoClass("key3", null));
        System.out.println(demo(demoList));
    }
}
