package com.lindaring.dictionary.utils;

import com.lindaring.dictionary.annotation.LogMethod;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public class SimpleUtils {

    @LogMethod
    public static void addAllNotNull(List<String> newList, List<String> oldList) {
        if (oldList != null && !oldList.isEmpty()) {
            oldList.forEach(item -> {
                if (!isEmpty(item)) {
                    newList.add(item);
                }
            });
        }
    }

}
