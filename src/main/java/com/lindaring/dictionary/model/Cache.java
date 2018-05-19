package com.lindaring.dictionary.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Cache {
    private List<String> keys;
}
