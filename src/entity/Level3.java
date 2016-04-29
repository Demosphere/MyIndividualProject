package entity;

import java.util.Set;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level3 {

    int levelThreeID;
    int levelTwoID;
    String listingName;
    String listingDescription;
    int versionID;
    String bookName;
    int pageNumber;
    private Set<Level4> levelFour;

    public Level3() {
        levelThreeID = 0;
        levelTwoID = 0;
        listingName = null;
        listingDescription = null;
        versionID = 0;
        bookName = null;
        pageNumber = 0;
        levelFour = null;
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

}
