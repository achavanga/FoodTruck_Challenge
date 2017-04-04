package za.co.camel.model;

/**
 * File Name : TruckData.java Project Name : SparkTest
 *
 * @since Apr 4, 2017, 9:50:07 PM
 * @author Abel Chavanga <achavanga@fnb.co.za>
 *
 */
public class TruckData {

    private String status;

    private Location location;

    private String expirationdate;

    private String permit;

    private String block;

    private String received;

    private String facilitytype;

    private String blocklot;

    private String locationdescription;

    private String cnn;

    private String priorpermit;

    private String schedule;

    private String approved;

    private String address;

    private String applicant;

    private String lot;

    private String fooditems;

    private String longitude;

    private String latitude;

    private String objectid;

    private String dayshours;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getFacilitytype() {
        return facilitytype;
    }

    public void setFacilitytype(String facilitytype) {
        this.facilitytype = facilitytype;
    }

    public String getBlocklot() {
        return blocklot;
    }

    public void setBlocklot(String blocklot) {
        this.blocklot = blocklot;
    }

    public String getLocationdescription() {
        return locationdescription;
    }

    public void setLocationdescription(String locationdescription) {
        this.locationdescription = locationdescription;
    }

    public String getCnn() {
        return cnn;
    }

    public void setCnn(String cnn) {
        this.cnn = cnn;
    }

    public String getPriorpermit() {
        return priorpermit;
    }

    public void setPriorpermit(String priorpermit) {
        this.priorpermit = priorpermit;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getFooditems() {
        return fooditems;
    }

    public void setFooditems(String fooditems) {
        this.fooditems = fooditems;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getDayshours() {
        return dayshours;
    }

    public void setDayshours(String dayshours) {
        this.dayshours = dayshours;
    }

    @Override
    public String toString() {
        return "Main [status = " + status + ", location = " + location + ", expirationdate = " + expirationdate + ", permit = " + permit + ", block = " + block + ", received = " + received + ", facilitytype = " + facilitytype + ", blocklot = " + blocklot + ", locationdescription = " + locationdescription + ", cnn = " + cnn + ", priorpermit = " + priorpermit + ", schedule = " + schedule + ", approved = " + approved + ", address = " + address + ", applicant = " + applicant + ", lot = " + lot + ", fooditems = " + fooditems + ", longitude = " + longitude + ", latitude = " + latitude + ", objectid = " + objectid + ", dayshours = " + dayshours + "]";
    }
}
