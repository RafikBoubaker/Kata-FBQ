package com.sg.kata_backend.domain.service;


import com.sg.kata_backend.domain.model.NumberTransformerService;
import org.springframework.stereotype.Service;

@Service
public class NumberTransformerServiceImpl implements NumberTransformerService {
    @Override
    public String transform(int number) {

        if (number < 0 || number > 100) {
            throw new IllegalArgumentException("Veuillez entrer un nombre entre 0 et 100.");
        }


        if (number == 0 || number == 100) {
            return String.valueOf(number);
        }

        String numberStr = String.valueOf(number);
        StringBuilder res = new StringBuilder();


        if (number % 3 == 0) {
            res.append("FOO");
        }
        if (number % 5 == 0) {
            res.append("BAR");
        }


        for (char digit : numberStr.toCharArray()) {
            switch (digit) {
                case '3':
                    if (res.indexOf("FOO") == -1) res.append("FOO");
                    break;
                case '5':
                    if (res.indexOf("BAR") == -1) res.append("BAR");
                    break;
                case '7':
                    res.append("QUIX");
                    break;
            }
        }

        return res.length() > 0 ? res.toString() : numberStr;
    }
}