package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class StreetPoints {
    private int _id;
    private String _streetnumber;
    private String _street;
    private String _lat;
    private String _lng;
    private String _subnumber;
    private int _street_id;
    private int _done;

    public StreetPoints() {

    }

    public StreetPoints(String streetnumber, String street, String lat, String lng, String subnumber, int street_id, int done){

        this._streetnumber = streetnumber;
        this._street = street;
        this._lat = lat;
        this._lng = lng;
        this._subnumber = subnumber;
        this._street_id = street_id;
        this._done = done;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_streetnumber() {
        return _streetnumber;
    }

    public void set_streetnumber(String _streetnumber) {
        this._streetnumber = _streetnumber;
    }

    public String get_street() {
        return _street;
    }

    public void set_street(String _street) {
        this._street = _street;
    }

    public String get_lat() {
        return _lat;
    }

    public void set_lat(String _lat) {
        this._lat = _lat;
    }

    public String get_lng() {
        return _lng;
    }

    public void set_lng(String _lng) {
        this._lng = _lng;
    }

    public String get_subnumber() {
        return _subnumber;
    }

    public void set_subnumber(String _subnumber) {
        this._subnumber = _subnumber;
    }

    public int get_street_id() {
        return _street_id;
    }

    public void set_street_id(int _street_id) {
        this._street_id = _street_id;
    }

    public int get_done() {
        return _done;
    }

    public void set_done(int _done) {
        this._done = _done;
    }
}
