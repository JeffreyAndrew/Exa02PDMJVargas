package com.jevar.salessystem.model;

import android.support.annotation.NonNull;

public class ProductId {

    public String prodId;

    public <T extends ProductId> T withId(@NonNull final String id){
        this.prodId = id;
        return (T) this;
    }
}
