package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Keywords {
    private int _id;
    private String _alias;
    private String _keyword;
    private String _classname;
    private String _aliasEn;
    private String _keywordEn;

    public Keywords() {

    }

    public Keywords(String alias, String aliasEn, String classname, String keyword, String keywordEn) {

        this._classname = classname;
        this._alias = alias;
        this._aliasEn = aliasEn;
        this._keyword = keyword;
        this._keywordEn = keywordEn;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public String get_keyword() {
        return _keyword;
    }

    public void set_keyword(String _keyword) {
        this._keyword = _keyword;
    }

    public String get_classname() {
        return _classname;
    }

    public void set_classname(String _classname) {
        this._classname = _classname;
    }

    public String get_aliasEn() {
        return _aliasEn;
    }

    public void set_aliasEn(String _aliasEn) {
        this._aliasEn = _aliasEn;
    }

    public String get_keywordEn() {
        return _keywordEn;
    }

    public void set_keywordEn(String _keywordEn) {
        this._keywordEn = _keywordEn;
    }
}
