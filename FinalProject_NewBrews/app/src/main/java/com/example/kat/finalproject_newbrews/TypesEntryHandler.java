package com.example.kat.finalproject_newbrews;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.util.ArrayList;

import java.util.ArrayList;

/**
 * Created by stephenthoen on 1/25/15.
 */
public class TypesEntryHandler extends DefaultHandler {

    private ArrayList<TypesEntry> _typesentries = new ArrayList<TypesEntry>();

    private String _TypeID, _TypeName;

    private String _data;

    public ArrayList<TypesEntry> get_types() {
        return _typesentries;
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
        if (qName.equals("TypeID"))
            _TypeID = _data;
        else if (qName.equals("TypeName"))
            _TypeName = _data;

        else if (qName.equals("Type")) {
            _typesentries.add(new TypesEntry(_TypeID, _TypeName));
        }
    }


}
