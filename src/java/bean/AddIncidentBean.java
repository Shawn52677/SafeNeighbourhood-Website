/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author VTEC
 */
public class AddIncidentBean implements java.io.Serializable{
    
    String title;
    String description;
    String location;
    String reportedBy;

    public AddIncidentBean() {
    }

    public AddIncidentBean(String title, String description, String location, String reportedBy) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.reportedBy = reportedBy;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }
    
}
