package org.LLD.strategies;

import org.LLD.entities.Command;

import java.util.List;

public interface IOStrategy {
    Command getUserInput();

    void print(List<String> output);
}
