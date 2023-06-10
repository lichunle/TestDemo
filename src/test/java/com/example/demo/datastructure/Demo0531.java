package com.example.demo.datastructure;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;

public class Demo0531 {

    public static void main(String[] args) {

//        try {
//            ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
//            System.out.println(scriptEngine.eval("3+2*(1+2*(-4/(8-6)+7))"));
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
        buyAnimals();
    }

    public static void buyAnimals() {

        for(int x = 0;x <= 14;x++) {
            if((100-7*x)%4==0) {
                int y = (100-7*x)/4;
                int z = 100-y-x;
                System.out.println(x+ " " + y+" "+z);
            }
        }
    }
}
