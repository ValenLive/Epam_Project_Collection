package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;


    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {//A1 B2 C3 ==== Index порядковий
        int columnIndex = shot.charAt(0) - 'A' + 1;
        int rowIndex = shot.charAt(1) - '0' - 1;
        int bitIndex = 64 - ((8 * rowIndex) + columnIndex);
        if (shots == 0) {
            shots = ships;
        }
        BigInteger boardBefore = BigInteger.valueOf(shots);
        BigInteger boardAfter = boardBefore.setBit(bitIndex);
        long shotsIn = boardAfter.longValue();
        String sBefore = String.format("%64s", Long.toBinaryString(ships)).replace(' ', '0');
        String sAfter = String.format("%64s", Long.toBinaryString(shotsIn)).replace(' ', '0');
        StringBuilder changeState = new StringBuilder(sAfter);
        if (sBefore.charAt(Math.abs(bitIndex - 63)) == '0' && sAfter.charAt(Math.abs(bitIndex - 63)) == '1') {
            changeState.setCharAt(Math.abs(bitIndex - 63), '1');
            String s = changeState.toString();
            shots = new BigInteger(s, 2).longValue();
            return false;
        }
        if (sBefore.charAt(Math.abs(bitIndex - 63)) == '1' && sAfter.charAt(Math.abs(bitIndex - 63)) == '1') {
            changeState.setCharAt(Math.abs(bitIndex - 63), '0');
            String s = changeState.toString();
            shots = new BigInteger(s, 2).longValue();
            return true;
        }
        return false;
    }

    public String state() {
        int j = 0;
        String sBefore = String.format("%64s", Long.toBinaryString(ships)).replace(' ', '0');
        String sAfter = String.format("%64s", Long.toBinaryString(shots)).replace(' ', '0');
        StringBuilder startState = new StringBuilder(sBefore);
        StringBuilder processState = new StringBuilder(sAfter);
        if (shots == 0L) {
            for (int i = 0; i < sBefore.length(); i++) {
                if (sBefore.charAt(i) == '1') {
                    startState.setCharAt(i, '☐');
                }
                if (sBefore.charAt(i) == '0') {
                    startState.setCharAt(i, '.');
                }
            }

            return startState.toString();
        } else {

            for (int i = 0; i < sAfter.length(); i++) {
                if (sBefore.charAt(i) == '1' && sAfter.charAt(i) == '0') {
                    processState.setCharAt(j, '☒');
                    j++;
                }
                if (sBefore.charAt(i) == '0' && sAfter.charAt(i) == '0') {
                    processState.setCharAt(j, '.');
                    j++;
                }
                if (sBefore.charAt(i) == '0' && sAfter.charAt(i) == '1') {
                    processState.setCharAt(j, '×');
                    j++;
                }
                if (sBefore.charAt(i) == '1' && sAfter.charAt(i) == '1') {
                    processState.setCharAt(j, '☐');
                    j++;
                }
                if ((i + 1) % 8 == 0 && (i + 1) != 64) {
                    processState.insert(j++, "\n");
                }
            }
            return processState.toString();
        }
    }

}
