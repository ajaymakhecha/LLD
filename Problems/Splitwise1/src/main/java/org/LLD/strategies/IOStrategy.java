package org.LLD.strategies;

import java.util.List;

public interface IOStrategy {
    Object getUserInput();

    void print(List<String> output);
}
