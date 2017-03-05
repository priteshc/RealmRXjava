package com.relam.myrelamdatabase.pojo;

import io.realm.RealmObject;

/**
 * Created by pritesh on 3/4/2017.
 */

public class Book extends RealmObject {

    String bookname,bookauthor;
    public static String BOOK_NAME = "bookname";
    public static String BOOK_AUTHOR = "bookauthor";

    public Book() {
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }
}
