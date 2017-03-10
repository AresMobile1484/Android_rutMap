package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Streets {
    private int _id;
    private String _name;
    private String _full_name;
    private String _alias;
    private String _coord;
    private String _startend;
    private String _polilines;
    private String _municipality;
    private int _status;
    private String _resorted;
    private String _searchkeywords;
    private int _counter;
    private String _nameLatin;
    private String _full_nameLatin;
    private String _searchkeywordsLatin;
    private String _aliasEn;

    public Streets() {

    }

    public Streets(String name, String full_name, String alias, String coord, String startend, String polilines, String municipality, int status,
                   String resorted, String searchkeywords, int counter, String nameLatin, String full_nameLatin, String searchkeywordsLatin, String aliasEn) {

        this._name = name;
        this._full_name = full_name;
        this._alias = alias;
        this._aliasEn = aliasEn;
        this._coord = coord;
        this._startend = startend;
        this._polilines = polilines;
        this._municipality = municipality;
        this._status = status;
        this._resorted = resorted;
        this._searchkeywords = searchkeywords;
        this._counter = counter;
        this._nameLatin = nameLatin;
        this._full_nameLatin = full_nameLatin;
        this._searchkeywordsLatin = searchkeywordsLatin;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_full_name() {
        return _full_name;
    }

    public void set_full_name(String _full_name) {
        this._full_name = _full_name;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_coord() {
        return _coord;
    }

    public void set_coord(String _coord) {
        this._coord = _coord;
    }

    public String get_startend() {
        return _startend;
    }

    public void set_startend(String _startend) {
        this._startend = _startend;
    }

    public String get_polilines() {
        return _polilines;
    }

    public void set_polilines(String _polilines) {
        this._polilines = _polilines;
    }

    public String get_municipality() {
        return _municipality;
    }

    public void set_municipality(String _municipality) {
        this._municipality = _municipality;
    }

    public int get_status() {
        return _status;
    }

    public void set_status(int _status) {
        this._status = _status;
    }

    public String get_resorted() {
        return _resorted;
    }

    public void set_resorted(String _resorted) {
        this._resorted = _resorted;
    }

    public String get_searchkeywords() {
        return _searchkeywords;
    }

    public void set_searchkeywords(String _searchkeywords) {
        this._searchkeywords = _searchkeywords;
    }

    public int get_counter() {
        return _counter;
    }

    public void set_counter(int _counter) {
        this._counter = _counter;
    }

    public String get_nameLatin() {
        return _nameLatin;
    }

    public void set_nameLatin(String _nameLatin) {
        this._nameLatin = _nameLatin;
    }

    public String get_full_nameLatin() {
        return _full_nameLatin;
    }

    public void set_full_nameLatin(String _full_nameLatin) {
        this._full_nameLatin = _full_nameLatin;
    }

    public String get_searchkeywordsLatin() {
        return _searchkeywordsLatin;
    }

    public void set_searchkeywordsLatin(String _searchkeywordsLatin) {
        this._searchkeywordsLatin = _searchkeywordsLatin;
    }

    public String get_aliasEn() {
        return _aliasEn;
    }

    public void set_aliasEn(String _aliasEn) {
        this._aliasEn = _aliasEn;
    }
}
