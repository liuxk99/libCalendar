package com.sj.time;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateDub {
    private DateStore store;
    private Date date;

    List<DateObserver> observerList = new ArrayList<>();

    public void setStore(DateStore store) {
        this.store = store;
        date = load();
    }

    Date load() {
        if (store != null) {
            try {
                return store.load();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    void save() {
        if (store != null) {
            store.save(this.date);
        }
    }

    public void setDate(Date date) {
        if (date != null && date != this.date) {
            this.date = (Date) date.clone();
            save();
        }
        notifyObserver();
    }

    public Date getDate() {
        return this.date;
    }

    public void addObserver(DateObserver observer) {
        observerList.add(observer);
    }

    public void notifyObserver() {
        for (DateObserver observer : observerList) {
            observer.onDateChanged(this.date);
        }
    }
}
