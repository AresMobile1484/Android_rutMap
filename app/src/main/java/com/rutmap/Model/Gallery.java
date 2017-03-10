package com.rutmap.Model;

/**
 * Created by Administrator on 2/13/2017.
 */

public class Gallery {
    private int _id;
    private int _object_id;
    private String _image;
    private int _sort;

    public Gallery() {

    }

    public Gallery(int object_id, String image, int sort) {

        this._object_id = object_id;
        this._image = image;
        this._sort = sort;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_object_id() {
        return _object_id;
    }

    public void set_object_id(int _object_id) {
        this._object_id = _object_id;
    }

    public String get_image() {
        return _image;
    }

    public void set_image(String _image) {
        this._image = _image;
    }

    public int get_sort() {
        return _sort;
    }

    public void set_sort(int _sort) {
        this._sort = _sort;
    }
}
