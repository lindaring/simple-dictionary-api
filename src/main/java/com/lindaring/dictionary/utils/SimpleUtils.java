package com.lindaring.dictionary.utils;

import com.lindaring.dictionary.annotation.LogMethod;

import java.time.LocalDate;
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

    @LogMethod
    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }

}
