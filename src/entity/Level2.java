package entity;

import java.util.Set;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level2 {

    int levelTwoID;
    int levelOneID;
    String listingName;
    String listingDescription;
    int versionID;
    String bookName;
    int pageNumber;
    private Set<Level3> levelThree;

    public Level2() {
        levelTwoID = 0;
        levelOneID = 0;
        listingName = null;
        listingDescription = null;
        versionID = 0;
        bookName = null;
        pageNumber = 0;
        levelThree = null;
    }

    public int getLevelTwoID() {
        return levelTwoID;
    }

    public void setLevelTwoID(int levelTwoID) {
        this.levelTwoID = levelTwoID;
    }

    public int getLevelOneID() {
        return levelOneID;
    }

    public void setLevelOneID(int levelThreeID) {
        this.levelOneID = levelThreeID;
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

    public Set<Level3> getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(Set<Level3> inLevelThree) {
        this.levelThree = inLevelThree;
    }

    public void addLevelThree(Level3 inLevelThree) {
        this.levelThree.add(inLevelThree);
    }
}
