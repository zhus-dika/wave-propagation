package com.wavepropagation.webapp.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/chart")
public class ChartResource {
    private Double lambda (Integer rho1, );
    @GetMapping("/all")
    public ResponseEntity<ArrayList<ArrayList<Double>>> getAllCharts(Integer rho1, Integer rho2,
                                                      Integer v1, Integer v2) {
        Double h = 0.01;
        Double PI = 3.14159265358;
        Integer n = 314;
        List<Double> xiArr = new ArrayList<>(n);
        Double init = 0.;
        for(int i = 0; i < n; i++) {
            xiArr.add(init);
            init = init + h;
        }
        ArrayList<ArrayList<Double>> graph = new ArrayList<>(n);
        lambdaK1Arr1 = Table[\[Lambda] /. {\[Xi] -> xiArr[[j]],Subscript[k, 1] -> 0.05}, {j, n}];
        velocityArr1 = Table[lambdaK1Arr1[[j]]/xiArr[[j]], {j, n}];
        for(int i = 0; i < n; i++) {
            List<Double> lambdaKArr = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                lambdaKArr.add(init);
            }
            xiArr.add(init);
            init = init + h;
        }
        return new ResponseEntity<>(graph, HttpStatus.OK);
    }
}
