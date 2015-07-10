package com.example.kat.finalproject_newbrews;

/**
 * Created by stephenthoen on 1/24/15.
 */
public class BeerEntry {

    private String _Craft_Beer_ID;
    private String _Craft_Beer_Name;
    private String _Craft_Beer_ABV;
    private String _Craft_Beer_Description;
    private String _Craft_Beer_BrewRelease;
    private String _Craft_Beer_Type;
    private String _Craft_Beer_Brewer;


    public BeerEntry(String id, String Beer_Name, String ABV, String Beer_Description, String BrewRelease,
                     String Beer_Type, String Beer_Brewer) {
        _Craft_Beer_ID = id;
        _Craft_Beer_Name = Beer_Name;
        _Craft_Beer_ABV = ABV;
        _Craft_Beer_Description = Beer_Description;
        _Craft_Beer_BrewRelease = BrewRelease;
        _Craft_Beer_Type = Beer_Type;
        _Craft_Beer_Brewer = Beer_Brewer;
    }


    public String get_Craft_Beer_Name() {
        return _Craft_Beer_Name;
    }

    public String get_Craft_Beer_ID() {
        return _Craft_Beer_ID;
    }

    public String get_Craft_Beer_ABV() {
        return _Craft_Beer_ABV;
    }

    public String get_Craft_Beer_Description() {
        return _Craft_Beer_Description;
    }

    public String get_Craft_Beer_BrewRelease() {
        return _Craft_Beer_BrewRelease;
    }

    public String get_Craft_Beer_Brewer() {
        return _Craft_Beer_Brewer;
    }


}
