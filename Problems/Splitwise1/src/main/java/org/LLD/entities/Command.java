package org.LLD.entities;

import org.LLD.services.SplitWiseManager;

import java.util.List;

public interface Command {

    List<String> execute(SplitWiseManager splitWiseManager);

}
