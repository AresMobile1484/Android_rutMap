package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class CategoriesEvents {
    private int _id;
    private String _classes;
    private String _title;
    private String _titleEn;

    public CategoriesEvents() {

    }

    public CategoriesEvents(String classes,String title, String titleEn) {
        this._classes = classes;
        this._title = title;
        this._titleEn = titleEn;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String get_classes() {
        return _classes;
    }

    public void set_classes(String _classes) {
        this._classes = _classes;
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
}
