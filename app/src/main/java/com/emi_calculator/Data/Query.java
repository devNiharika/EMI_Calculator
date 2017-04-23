package com.emi_calculator.Data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Niharika Rastogi on 23-04-2017.
 */

@Table(name = "Queries", id = "_id")
public class Query extends Model {

    //Column to store principal amount
    @Column
    public int PRINCIPAL;

    //Column to store tenure
    @Column
    public int TENURE;

    // Column to store User's Mobile Number
    @Column
    public String MOBILE_NUMBER;
}
