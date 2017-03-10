package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Categories {
    private int _id;
    private String _name;
    private int _parent_id;
    private String _params;
    private int _status;
    private String _classname;
    private String _html;
    private String _alias;
    private int _lang_del;
    private String _nameLatin;
    private String _nameEn;
    private String _nameLatinEn;
    private String _aliasEn;

    public Categories() {

    }

    public Categories(String name, int parent_id, String params, int status, String classname, String html, String alias, int lang_del,
                      String nameLatin, String nameEn, String nameLatinEn, String aliasEn) {
        this._name = name;
        this._parent_id = parent_id;
        this._params = params;
        this._status = status;
        this._classname = classname;
        this._html = html;
        this._alias = alias;
        this._lang_del = lang_del;
        this._nameLatin = nameLatin;
        this._nameEn = nameEn;
        this._nameLatinEn = nameLatinEn;
        this._aliasEn = aliasEn;
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

    public int get_parent_id() {
        return _parent_id;
    }

    public void set_parent_id(int _parent_id) {
        this._parent_id = _parent_id;
    }

    public String get_params() {
        return _params;
    }

    public void set_params(String _params) {
        this._params = _params;
    }

    public int get_status() {
        return _status;
    }

    public void set_status(int _status) {
        this._status = _status;
    }

    public String get_classname() {
        return _classname;
    }

    public void set_classname(String _classname) {
        this._classname = _classname;
    }

    public String get_html() {
        return _html;
    }

    public void set_html(String _html) {
        this._html = _html;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public int get_lang_del() {
        return _lang_del;
    }

    public void set_lang_del(int _lang_del) {
        this._lang_del = _lang_del;
    }

    public String get_nameLatin() {
        return _nameLatin;
    }

    public void set_nameLatin(String _nameLatin) {
        this._nameLatin = _nameLatin;
    }

    public String get_nameEn() {
        return _nameEn;
    }

    public void set_nameEn(String _nameEn) {
        this._nameEn = _nameEn;
    }

    public String get_nameLatinEn() {
        return _nameLatinEn;
    }

    public void set_nameLatinEn(String _nameLatinEn) {
        this._nameLatinEn = _nameLatinEn;
    }

    public String get_aliasEn() {
        return _aliasEn;
    }

    public void set_aliasEn(String _aliasEn) {
        this._aliasEn = _aliasEn;
    }
}
