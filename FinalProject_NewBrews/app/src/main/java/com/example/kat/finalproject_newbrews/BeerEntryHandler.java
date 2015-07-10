package com.example.kat.finalproject_newbrews;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.util.ArrayList;

/**
 * Created by stephenthoen on 1/24/15.
 */
public class BeerEntryHandler extends DefaultHandler {

    private ArrayList<BeerEntry> _entries = new ArrayList<BeerEntry>();

    private String _Craft_Beer_BrewRelease;
    private String _Craft_Beer_ID,
            _Craft_Beer_Name,
            _Craft_Beer_ABV,
            _Craft_Beer_Description,
            _Craft_Beer_Type,
            _Craft_Beer_Brewer;

    private String _data;

    public ArrayList<BeerEntry> get_entries() {
        return _entries;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        _data = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        _data = _data + new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("ACraftID"))
            _Craft_Beer_ID = _data;
        else if (qName.equals("ACraftName"))
            _Craft_Beer_Name = _data;
        else if (qName.equals("ACraftABV"))
            _Craft_Beer_ABV = _data;
        else if (qName.equals("ACraftDescription"))
            _Craft_Beer_Description = _data;
        else if (qName.equals("ABeerTypeID"))
            _Craft_Beer_Type = _data;
        else if (qName.equals("ABrewerName")) {
            _Craft_Beer_Brewer = _data;
        } else if (qName.equals("ABrewRelease")) {
            _Craft_Beer_BrewRelease = _data;
        } else if (qName.equals("beer")) {
            _entries.add(new BeerEntry(_Craft_Beer_ID, _Craft_Beer_Name, _Craft_Beer_ABV, _Craft_Beer_Description,
                    _Craft_Beer_BrewRelease, _Craft_Beer_Type, _Craft_Beer_Brewer));
        }
    }


}
