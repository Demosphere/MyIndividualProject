package entity;

import com.google.gson.annotations.Expose;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level4 {

    @Expose int levelFourID;
    @Expose int levelThreeID;
    @Expose String listingName;
    @Expose String listingDescription;
    @Expose int versionID;
    @Expose String bookName;
    @Expose int pageNumber;

    public Level4() {
        levelFourID = 0;
        levelThreeID = 0;
        listingName = null;
        listingDescription = null;
        versionID = 0;
        bookName = null;
        pageNumber = 0;
    }

    public int getLevelFourID() {
        return levelFourID;
    }

    public void setLevelFourID(int levelOneID) {
        this.levelFourID = levelOneID;
    }

    public int getLevelThreeID() {
        return levelThreeID;
    }

    public void setLevelThreeID(int levelThreeID) {
        this.levelThreeID = levelThreeID;
    }

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public String getListingDescription() {
        return listingDescription;
    }

    public void setListingDescription(String listingDescription) {
        this.listingDescription = listingDescription;
    }

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}
