package com.example.kat.finalproject_newbrews;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by stephenthoen on 1/25/15.
 */
public class RestEntryHandler extends DefaultHandler {

    private ArrayList<RestEntry> _Restsentries = new ArrayList<RestEntry>();

    private String _RestID_Num;
    private String _RestName;
    private String _RestPhone;
    private String _RestAddress;
    private String _RestCity;
    private String _RestState;
    private String _RestDescription;
    private String _RestZip;

    private String _data;

    public ArrayList<RestEntry> get_types() {
        return _Restsentries;
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
        if (qName.equals("RestID"))
            _RestID_Num = _data;
        else if (qName.equals("RestName"))
            _RestName = _data;
        else if (qName.equals("RestPhone"))
            _RestPhone = _data;
        else if (qName.equals("RestAddress"))
            _RestAddress = _data;
        else if (qName.equals("RestCity"))
            _RestCity = _data;
        else if (qName.equals("RestState"))
            _RestState = _data;
        else if (qName.equals("RestDescrip"))
            _RestDescription = _data;
        else if (qName.equals("RestZip"))
            _RestZip = _data;

        else if (qName.equals("Rests")) {
            _Restsentries.add(new RestEntry(_RestID_Num, _RestName, _RestPhone, _RestAddress,
                    _RestCity, _RestState, _RestDescription, _RestZip));
        }
    }


}
