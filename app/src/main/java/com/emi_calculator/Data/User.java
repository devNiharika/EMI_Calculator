package com.emi_calculator.Data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Niharika Rastogi on 23-04-2017.
 */
@Table(name = "Users", id = "_id")
public class User extends Model {

    // Column to store User's Name
    @Column
    public String NAME;

    // Column to store User's Mobile Number
    @Column(unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public String MOBILE_NUMBER;

    // Column to store User's Email
    @Column
    public String EMAIL;

    //Column to store User's Query
    @Column
    public Query QUERY;

    public User() {
        // Default Constructor
        super();
    }

}
