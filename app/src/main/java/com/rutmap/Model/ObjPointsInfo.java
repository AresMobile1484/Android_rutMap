package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class ObjPointsInfo {
    private int _id;
    private int _obj_id;
    private String _telefon;
    private String _fax;
    private String _mail;
    private String _web;
    private String _slika;
    private String _imgurl;
    private String _imgurl2;
    private String _imgurl3;
    private String _classImg;
    private String _centar1;
    private String _centar2;
    private String _centar3;
    private String _centar4;
    private String _worktime;
    private String _worktimeEn;

    public ObjPointsInfo() {

    }

    public ObjPointsInfo(int obj_id, String telefon, String fax, String mail, String web, String slika, String imgurl, String imgurl2,
                         String imgurl3, String classImg, String centar1, String centar2, String centar3, String centar4, String worktime, String worktimeEn) {

        this._obj_id = obj_id;
        this._telefon = telefon;
        this._fax = fax;
        this._mail = mail;
        this._web = web;
        this._slika = slika;
        this._imgurl = imgurl;
        this._imgurl2 = imgurl2;
        this._imgurl3 = imgurl3;
        this._classImg = classImg;
        this._centar1 = centar1;
        this._centar2 = centar2;
        this._centar3 = centar3;
        this._centar4 = centar4;
        this._worktime = worktime;
        this._worktimeEn = worktimeEn;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_obj_id() {
        return _obj_id;
    }

    public void set_obj_id(int _obj_id) {
        this._obj_id = _obj_id;
    }

    public String get_telefon() {
        return _telefon;
    }

    public void set_telefon(String _telefon) {
        this._telefon = _telefon;
    }

    public String get_fax() {
        return _fax;
    }

    public void set_fax(String _fax) {
        this._fax = _fax;
    }

    public String get_mail() {
        return _mail;
    }

    public void set_mail(String _mail) {
        this._mail = _mail;
    }

    public String get_web() {
        return _web;
    }

    public void set_web(String _web) {
        this._web = _web;
    }

    public String get_slika() {
        return _slika;
    }

    public void set_slika(String _slika) {
        this._slika = _slika;
    }

    public String get_imgurl() {
        return _imgurl;
    }

    public void set_imgurl(String _imgurl) {
        this._imgurl = _imgurl;
    }

    public String get_imgurl2() {
        return _imgurl2;
    }

    public void set_imgurl2(String _imgurl2) {
        this._imgurl2 = _imgurl2;
    }

    public String get_imgurl3() {
        return _imgurl3;
    }

    public void set_imgurl3(String _imgurl3) {
        this._imgurl3 = _imgurl3;
    }

    public String get_classImg() {
        return _classImg;
    }

    public void set_classImg(String _classImg) {
        this._classImg = _classImg;
    }

    public String get_centar1() {
        return _centar1;
    }

    public void set_centar1(String _centar1) {
        this._centar1 = _centar1;
    }

    public String get_centar2() {
        return _centar2;
    }

    public void set_centar2(String _centar2) {
        this._centar2 = _centar2;
    }

    public String get_centar3() {
        return _centar3;
    }

    public void set_centar3(String _centar3) {
        this._centar3 = _centar3;
    }

    public String get_centar4() {
        return _centar4;
    }

    public void set_centar4(String _centar4) {
        this._centar4 = _centar4;
    }

    public String get_worktime() {
        return _worktime;
    }

    public void set_worktime(String _worktime) {
        this._worktime = _worktime;
    }

    public String get_worktimeEn() {
        return _worktimeEn;
    }

    public void set_worktimeEn(String _worktimeEn) {
        this._worktimeEn = _worktimeEn;
    }
}
