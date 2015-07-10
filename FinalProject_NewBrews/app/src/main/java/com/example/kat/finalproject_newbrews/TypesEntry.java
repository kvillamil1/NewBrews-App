package com.example.kat.finalproject_newbrews;

/**
 * Created by stephenthoen on 1/25/15.
 */
public class TypesEntry {

    private String _Craft_Type_ID;
    private String _Craft_Type_Name;


    public TypesEntry(String id, String Type_Name) {
        _Craft_Type_ID = id;
        _Craft_Type_Name = Type_Name;
    }

    public String getTypeName() {
        return _Craft_Type_Name;
    }

    public String getTypeID() {
        return _Craft_Type_ID;
    }


}
