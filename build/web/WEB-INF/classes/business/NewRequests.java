/*
 * This class contains the variables of the technician request
 * including constructors, getters, and setters
 * © 12/3/2017 Sarah Bean
 */
package business;

import java.io.Serializable;
import java.sql.Date;

//Private variables for registration as new user

/**
 *
 * @author Sarah
 */
public class NewRequests implements Serializable {

    private int reqId;

    /**
     *
     */
    public String lastName;
    private Date reqDate;

    /**
     *
     */
    public Date compDate;
    private String reqDesc;
    private String notes;

    /**
     *
     */
    public NewRequests() {
        lastName = "";
        reqDate = null;
        compDate = null;
        reqDesc = "";
        notes = "";
    }

    /**
     *
     * @param lastName
     * @param reqDate
     * @param compDate
     * @param reqDesc
     * @param notes
     */
    public NewRequests(String lastName, Date reqDate, Date compDate, String reqDesc, String notes) {
        this.lastName = lastName;
        this.reqDate = reqDate;
        this.compDate = compDate;
        this.reqDesc = reqDesc;
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    public int getReqId() {
        return reqId;
    }

    /**
     *
     * @param reqId
     */
    public void setReqId(int reqId) {
        this.reqId = reqId;

    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public Date getReqDate() {
        return reqDate;
    }

    /**
     *
     * @param reqDate
     */
    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    /**
     *
     * @return
     */
    public Date getCompDate() {
        return compDate;
    }

    /**
     *
     * @param compDate
     */
    public void setCompDate(Date compDate) {
        this.compDate = compDate;
    }

    /**
     *
     * @return
     */
    public String getReqDesc() {
        return reqDesc;
    }

    /**
     *
     * @param reqDesc
     */
    public void setReqDesc(String reqDesc) {
        this.reqDesc = reqDesc;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    public boolean setIsProcessed() {
        return this.compDate != null;
    }
}
