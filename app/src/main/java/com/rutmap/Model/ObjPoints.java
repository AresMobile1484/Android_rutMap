package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class ObjPoints {
    private int _id;
    private String _naziv;
    private String _alias;
    private int _cat_id;
    private int _street_id;
    private String _description;
    private String _lat;
    private String _lon;
    private String _obj_info;
    private int _stv;
    private String _krpano;
    private int _status;
    private String _searchkeywords;
    private int _counter;
    private int _minzoom;
    private String _streetnumber;
    private String _inbuildinglevel;
    private int _vrsta;
    private int _parent_id;
    private int _packages;
    private int _showOnSearch;
    private String _nazivLatin;
    private String _searchkeywordsLatin;
    private String _obj_infoLatin;
    private int _usr;
    private String _nazivEn;
    private String _aliasEn;
    private String _descriptionEn;
    private String _obj_infoEn;
    private String _nazivLatinEn;
    private String _obj_infoLatinEn;
    private String _created;
    private String _status_true;
    private String _status_update;

    public ObjPoints() {

    }

    public ObjPoints( String naziv, String alias, int cat_id, int street_id, String description,String lat,String lon,String obj_info, int stv,
                      String krpano,int status,String searchkeywords,int counter,int minzoom,String streetnumber,String inbuildinglevel,int vrsta,
                      int parent_id,int packages,int showOnSearch,String nazivLatin,String searchkeywordsLatin,String obj_infoLatin,int usr,String nazivEn,
                      String aliasEn,String descriptionEn,String obj_infoEn,String nazivLatinEn,String obj_infoLatinEn,String created,String status_true,String status_update ) {
        this._naziv = naziv;                    this._alias= alias;
        this._cat_id = cat_id;                  this._street_id = street_id;
        this._description = description;        this._lat = lat;
        this._lon = lon;                        this._obj_info = obj_info;
        this._stv = stv;                        this._krpano = krpano;
        this._status = status;                  this._searchkeywords = searchkeywords;
        this._counter = counter;                this._minzoom = minzoom;
        this._streetnumber = streetnumber;      this._inbuildinglevel = inbuildinglevel;
        this._vrsta = vrsta;                    this._parent_id = parent_id;
        this._packages = packages;              this._showOnSearch = showOnSearch;
        this._nazivLatin = nazivLatin;          this._searchkeywordsLatin = searchkeywordsLatin;
        this._obj_infoLatin = obj_infoLatin;    this._usr = usr;
        this._nazivEn = nazivEn;                this._aliasEn = aliasEn;
        this._descriptionEn = descriptionEn;    this._obj_infoEn = obj_infoEn;
        this._nazivLatinEn = nazivLatinEn;      this._obj_infoLatinEn = obj_infoLatinEn;
        this._created = created;                this._status_true = status_true;
        this._status_update = status_update;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_naziv() {
        return _naziv;
    }

    public void set_naziv(String _naziv) {
        this._naziv = _naziv;
    }

    public String get_alias() {
        return _alias;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public int get_cat_id() {
        return _cat_id;
    }

    public void set_cat_id(int _cat_id) {
        this._cat_id = _cat_id;
    }

    public int get_street_id() {
        return _street_id;
    }

    public void set_street_id(int _street_id) {
        this._street_id = _street_id;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_lat() {
        return _lat;
    }

    public void set_lat(String _lat) {
        this._lat = _lat;
    }

    public String get_lon() {
        return _lon;
    }

    public void set_lon(String _lon) {
        this._lon = _lon;
    }

    public String get_obj_info() {
        return _obj_info;
    }

    public void set_obj_info(String _obj_info) {
        this._obj_info = _obj_info;
    }

    public int get_stv() {
        return _stv;
    }

    public void set_stv(int _stv) {
        this._stv = _stv;
    }

    public String get_krpano() {
        return _krpano;
    }

    public void set_krpano(String _krpano) {
        this._krpano = _krpano;
    }

    public int get_status() {
        return _status;
    }

    public void set_status(int _status) {
        this._status = _status;
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

    public int get_minzoom() {
        return _minzoom;
    }

    public void set_minzoom(int _minzoom) {
        this._minzoom = _minzoom;
    }

    public String get_streetnumber() {
        return _streetnumber;
    }

    public void set_streetnumber(String _streetnumber) {
        this._streetnumber = _streetnumber;
    }

    public String get_inbuildinglevel() {
        return _inbuildinglevel;
    }

    public void set_inbuildinglevel(String _inbuildinglevel) {
        this._inbuildinglevel = _inbuildinglevel;
    }

    public int get_vrsta() {
        return _vrsta;
    }

    public void set_vrsta(int _vrsta) {
        this._vrsta = _vrsta;
    }

    public int get_parent_id() {
        return _parent_id;
    }

    public void set_parent_id(int _parent_id) {
        this._parent_id = _parent_id;
    }

    public int get_packages() {
        return _packages;
    }

    public void set_packages(int _packages) {
        this._packages = _packages;
    }

    public int get_showOnSearch() {
        return _showOnSearch;
    }

    public void set_showOnSearch(int _showOnSearch) {
        this._showOnSearch = _showOnSearch;
    }

    public String get_nazivLatin() {
        return _nazivLatin;
    }

    public void set_nazivLatin(String _nazivLatin) {
        this._nazivLatin = _nazivLatin;
    }

    public String get_searchkeywordsLatin() {
        return _searchkeywordsLatin;
    }

    public void set_searchkeywordsLatin(String _searchkeywordsLatin) {
        this._searchkeywordsLatin = _searchkeywordsLatin;
    }

    public String get_obj_infoLatin() {
        return _obj_infoLatin;
    }

    public void set_obj_infoLatin(String _obj_infoLatin) {
        this._obj_infoLatin = _obj_infoLatin;
    }

    public int get_usr() {
        return _usr;
    }

    public void set_usr(int _usr) {
        this._usr = _usr;
    }

    public String get_nazivEn() {
        return _nazivEn;
    }

    public void set_nazivEn(String _nazivEn) {
        this._nazivEn = _nazivEn;
    }

    public String get_aliasEn() {
        return _aliasEn;
    }

    public void set_aliasEn(String _aliasEn) {
        this._aliasEn = _aliasEn;
    }

    public String get_descriptionEn() {
        return _descriptionEn;
    }

    public void set_descriptionEn(String _descriptionEn) {
        this._descriptionEn = _descriptionEn;
    }

    public String get_obj_infoEn() {
        return _obj_infoEn;
    }

    public void set_obj_infoEn(String _obj_infoEn) {
        this._obj_infoEn = _obj_infoEn;
    }

    public String get_nazivLatinEn() {
        return _nazivLatinEn;
    }

    public void set_nazivLatinEn(String _nazivLatinEn) {
        this._nazivLatinEn = _nazivLatinEn;
    }

    public String get_obj_infoLatinEn() {
        return _obj_infoLatinEn;
    }

    public void set_obj_infoLatinEn(String _obj_infoLatinEn) {
        this._obj_infoLatinEn = _obj_infoLatinEn;
    }

    public String get_created() {
        return _created;
    }

    public void set_created(String _created) {
        this._created = _created;
    }

    public String get_status_true() {
        return _status_true;
    }

    public void set_status_true(String _status_true) {
        this._status_true = _status_true;
    }

    public String get_status_update() {
        return _status_update;
    }

    public void set_status_update(String _status_update) {
        this._status_update = _status_update;
    }
}
