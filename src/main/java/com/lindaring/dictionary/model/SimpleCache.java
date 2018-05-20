package com.lindaring.dictionary.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Builder
public class SimpleCache {
    private Collection<String> names;
    private List<String> keys;
}
