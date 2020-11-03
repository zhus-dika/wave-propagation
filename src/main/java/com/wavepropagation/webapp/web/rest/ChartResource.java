package com.wavepropagation.webapp.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/chart")
public class ChartResource {
    private Double lambda (Double xi, Double k1, Double rho1, Double rho2, Double v1, Double v2) {
        Double k12 = v2 / v1;
        Double tau12 = rho1 / rho2;
        return Math.sqrt((2 * (1 - Math.cos(xi)) * tau12) / ((0.25 - k1 + k1 * k1 * (1 - tau12) + 0.25 * tau12) * tau12 +
         Math.pow(k12, 4) * (0.25 + 0.25 * tau12 + k1 * tau12 + k1 * k1 * (-1 + tau12))));
    }
    @GetMapping("/all")
    public ResponseEntity<List<List<Double>>> getAllCharts(@RequestParam Double rho1, @RequestParam Double rho2,
                                                      @RequestParam Double v1, @RequestParam Double v2) {
        Double PI = 3.14159265358;
        Integer n = 100;
        Double h = PI / n;
        List<Double> xiArr = new ArrayList<>();
        Double init = h;
        for(int i = 0; i < n; i++) {
            xiArr.add(init);
            init = init + h;
        }
        List<List<Double>> graph = new ArrayList<List<Double>>();
        Double k1 = 0.05;
        for(int i = 0; i < 5; i++) {
            List<Double> vArr = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                Double val = lambda(xiArr.get(j), k1, rho1, rho2, v1, v2);
                vArr.add(val / xiArr.get(j));
            }
            k1 += 0.05;
            graph.add(vArr);
        }
        return new ResponseEntity<>(graph, HttpStatus.OK);
    }
}
