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
public class ViewIncidentBean implements java.io.Serializable{
    
    String title;
    String description;
    String location;
    String reportedBy;
    String status;

    public ViewIncidentBean() {
    }

    public ViewIncidentBean(String title, String description, String location, String reportedBy, String status) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.reportedBy = reportedBy;
        this.status = status;
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

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
