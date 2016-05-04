package entity;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level3 {

    @Expose int levelThreeID;
    @Expose int levelTwoID;
    @Expose String listingName;
    @Expose String listingDescription;
    @Expose int versionID;
    @Expose String bookName;
    @Expose int pageNumber;
    @Expose private Set<Level4> levelFour;
    private Level2 levelTwo;

    public Level3() {
    }

    public int getLevelThreeID() {
        return levelThreeID;
    }

    public void setLevelThreeID(int levelThreeID) {
        this.levelThreeID = levelThreeID;
    }

    public int getLevelTwoID() {
        return levelTwoID;
    }

    public void setLevelTwoID(int levelTwoID) {
        this.levelTwoID = levelTwoID;
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

    public Set<Level4> getLevelFour() {
        return levelFour;
    }

    public void setLevelFour(Set<Level4> inLevelFour) {
        this.levelFour = inLevelFour;
    }

    public void addLevelFour(Level4 inLevelFour) {
        this.levelFour.add(inLevelFour);
    }

    public Level2 getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(Level2 levelTwo) {
        this.levelTwo = levelTwo;
    }
}
