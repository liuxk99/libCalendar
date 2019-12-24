package com.sj.time;

import java.text.ParseException;
import java.util.Date;

public interface DateStore {
    Date load() throws ParseException;

    void save(Date date);
}
