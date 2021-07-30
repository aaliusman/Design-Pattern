package org.usmanacademy.AbsComponents;

import java.util.HashMap;

public interface SearchFlightAvail {

    void checkAvail(HashMap<String, String> selectCity) throws InterruptedException;
}
