package com.jhkim2.udemyfirstwebfluxdemo.service;

import com.jhkim2.udemyfirstwebfluxdemo.dto.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Response findSquare(int input){
        return new Response(input * input);
    }

    public List<Response> multiplicationTable(int input){
        return IntStream.rangeClosed(1,10)
            .peek(i -> SleepUtil.sleepSeconds(1))
            .peek(i -> System.out.println("math-service processing : " + i))
            .mapToObj(i -> new Response(i * input))
            .collect(Collectors.toList());
    }

}
