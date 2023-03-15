package com.example.numbercheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wei.haothoughtworks.com
 */
@RestController
@RequestMapping("/number-check")
public class NumberCheckController {

    NumberCheckService numberCheckService = new NumberCheckService();

    @GetMapping("/odd-or-even")
    public List<String> numberIsOddOrEven(@RequestBody List<Integer> numbers) {
        return numberCheckService.oddOrEven(numbers);
    }
}
