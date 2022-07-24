package io.github.camillesan.hedera.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Income {

    private String label;
    private String type;
    private BigDecimal amount;

}
