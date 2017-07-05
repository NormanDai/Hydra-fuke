package com.hydra.core.wrapper;

import com.hydra.core.common.DistributedStrategyEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DistributedWrapper {

    private DistributedStrategyEnum strategy;

    private int number;

}
