/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package units;

import cpu.Operation;
import cpu.Register;

public class Alu {

    private final Register collector;
    private final Register input;

    public Alu() {
        this.input = new Register();
        this.collector = new Register();
        collector.putRegistry(0);
    }

    public void setInput(int input) {
        this.input.putRegistry(input);
    }

    public int getCollector() {
        int temp = collector.getLastRegistry();
        collector.putRegistry(0);

        return temp;
    }

    private void setCollector(int collector) {
        this.collector.putRegistry(collector);
    }

    private void sum() {
        setCollector(collector.getLastRegistry() + input.getLastRegistry());
    }

    private void subtraction() {
        setCollector(collector.getLastRegistry() - input.getLastRegistry());
    }

    private void product() {
        setCollector(collector.getLastRegistry() * input.getLastRegistry());
    }

    private void power() {
        int base = collector.getLastRegistry(),
                index = input.getLastRegistry(),
                power = base;
        
        for (int i = 1; i < index; i++) {
            power *= base;
        }
        
        setCollector(power);
    }

    private void not() {
        String tempValIn = completeByte(Integer.toBinaryString(input.getLastRegistry())),
                tempValOut = "";

        for (String c : tempValIn.split("")) {
            tempValOut = tempValOut.concat("0".equals(c) ? "1" : "0");
        }

        
        collector.putRegistry(Integer.parseInt(tempValOut, 2));
    }

    private void nor() {
        String[] tempVal1 = completeByte(Integer.toBinaryString(input.getLastRegistry())).split(""),
                tempVal2 = completeByte(Integer.toBinaryString(collector.getLastRegistry())).split("");

        String result = "";

        for (int i = 0; i < tempVal1.length; i++) {
            result = result.concat(!(tempVal1[i].equals("1") || tempVal2[i].equals("1")) ? "1" : "0");
        }

        collector.putRegistry(Integer.parseInt(result, 2));
    }

    private void and() {
        String[] tempVal1 = completeByte(Integer.toBinaryString(input.getLastRegistry())).split(""),
                tempVal2 = completeByte(Integer.toBinaryString(collector.getLastRegistry())).split("");

        String result = "";

        for (int i = 0; i < tempVal1.length; i++) {
            result = result.concat(tempVal1[i].equals("1") && tempVal2[i].equals("1") ? "1" : "0");
        }

        collector.putRegistry(Integer.parseInt(result, 2));
    }

    private void mod() {
        collector.putRegistry(collector.getLastRegistry() % input.getLastRegistry());
    }

    private String completeByte(String value) {
        while (value.length() < 8) {
            value = "0" + value;
        }
        return value;
    }

    public void execute(Operation operation) {
        switch (operation) {
            case SUM:
                sum();
                break;
            case SUBTRACTION:
                subtraction();
                break;
            case PRODUCT:
                product();
                break;
            case POWER:
                power();
                break;
            case NOT:
                not();
                break;
            case NOR:
                nor();
                break;
            case AND:
                and();
                break;
            case MOD:
                mod();
                break;
            default:
                throw new IllegalArgumentException("No se reconoce la operacion seleccionada-ALU");
        }
    }

    public Object getRegistryEntry() {
        return input;
    }

    public Object getRegistryCollector() {
        return collector;
    }
}
