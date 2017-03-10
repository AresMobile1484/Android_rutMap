package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Events {
    private int _id;
    private String _title;
    private String _titleEn;
    private int _object_id;
    private String _alias;
    private String _aliasEn;
    private String _details;
    private String _detailsEn;
    private String _mainPic;
    private String _tel;
    private String _eventtime;
    private String _eventtimes;
    private int _category_id;
    private String _email;
    private int _published;
    private int _sff;
    private int _special;

    public Events() {

    }

    public Events(String title, String titleEn, int object_id, String alias, String aliasEn, String details, String detailsEn, String mainPic,
                  String tel, String eventtime, int category_id, String email, int published,int sff, int special ) {
        this._title = title;
        this._titleEn= titleEn;
        this._object_id = object_id;
        this._alias = alias;
        this._aliasEn = aliasEn;
        this._details = details;
        this._detailsEn = detailsEn;
        this._mainPic = mainPic;
        this._tel = tel;
        this._eventtime = eventtime;
        this._category_id = category_id;
        this._email = email;
        this._published = published;
        this._sff = sff;
        this._special = special;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_titleEn() {
        return _titleEn;
    }

    public void set_titleEn(String _titleEn) {
        this._titleEn = _titleEn;
    }

    public int get_object_id() {
        return _object_id;
    }

    public void set_object_id(int _object_id) {
        this._object_id = _object_id;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_aliasEn() {
        return _aliasEn;
    }

    public void set_aliasEn(String _aliasEn) {
        this._aliasEn = _aliasEn;
    }

    public String get_details() {
        return _details;
    }

    public void set_details(String _details) {
        this._details = _details;
    }

    public String get_detailsEn() {
        return _detailsEn;
    }

    public void set_detailsEn(String _detailsEn) {
        this._detailsEn = _detailsEn;
    }

    public String get_mainPic() {
        return _mainPic;
    }

    public void set_mainPic(String _mainPic) {
        this._mainPic = _mainPic;
    }

    public String get_tel() {
        return _tel;
    }

    public void set_tel(String _tel) {
        this._tel = _tel;
    }

    public String get_eventtime() {
        return _eventtime;
    }

    public void set_eventtime(String _eventtime) {
        this._eventtime = _eventtime;
    }

    public int get_category_id() {
        return _category_id;
    }

    public void set_category_id(int _category_id) {
        this._category_id = _category_id;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public int get_published() {
        return _published;
    }

    public void set_published(int _published) {
        this._published = _published;
    }

    public int get_sff() {
        return _sff;
    }

    public void set_sff(int _sff) {
        this._sff = _sff;
    }

    public int get_special() {
        return _special;
    }

    public void set_special(int _special) {
        this._special = _special;
    }
}
