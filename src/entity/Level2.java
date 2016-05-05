package entity;

import com.google.gson.annotations.Expose;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level2 {

    @Expose int levelTwoID;
    @Expose int levelOneID;
    @Expose String listingName;
    @Expose String listingDescription;
    @Expose int versionID;
    @Expose String bookName;
    @Expose int pageNumber;
    @Expose
    @OneToMany(fetch= FetchType.EAGER, targetEntity=Level3.class, cascade= CascadeType.ALL)
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
//        levelOne = null;
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
