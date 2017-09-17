package com.univ.dao;

import java.io.Serializable;

public interface Identificator<PK extends Serializable> {
    int getId();
}