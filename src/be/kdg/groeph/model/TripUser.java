package be.kdg.groeph.model;

import be.kdg.groeph.model.Null.NullUser;
import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TripUser implements Nullable, Serializable {

    private int id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private char gender;
    private String email;
    private String password;
    private String tempPassword;
    private String role;
    private Date dateRegistered;
    private Address address;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean accountNonLocked;
    //organised Trips
    private List<Trip> trips;

    /*@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    //@JoinColumn(name="id", nullable = true)
    @JoinTable(name="trip_user_invited")
    private List<Trip> invitedTrips = new ArrayList<Trip>();


    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    //@JoinColumn(name="id", nullable = true)
    @JoinTable(name="trip_user_confirmed")
    private List<Trip> confirmedTrips = new ArrayList<Trip>();  */


    private List<Trip> invitedTrips = new ArrayList<Trip>();

    private List<Trip> confirmedTrips = new ArrayList<Trip>();

    private List<Accessory> accessories;




    public TripUser() {
    }

    public TripUser(String firstName, String lastName, Date dateOfBirth, String phoneNumber, char gender, String email, String password, Address address, Date dateRegistered, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dateRegistered = dateRegistered;
        this.role = role;
        trips = new ArrayList<Trip>();
        accessories = new ArrayList<Accessory>();
    }

    public TripUser(String firstName, String lastName, Date dateOfBirth, String phoneNumber, char gender, String email, String password, String tempPassword, Address address, Date dateRegistered, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dateRegistered = dateRegistered;
        this.role = role;
        this.tempPassword = tempPassword;
        accessories = new ArrayList<Accessory>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Trip> getInvitedTrips() {
        return invitedTrips;
    }

    public void setInvitedTrips(List<Trip> invitedTrips) {
        this.invitedTrips = invitedTrips;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isAdmin(){
        if(role.equals("ROLE_ADMIN")){
            return  true;
        }
        return false;
    }
    public List<Trip> getTrips() {
        return trips;
    }

    public String getTempPassword() {
        return tempPassword;
    }
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public void addTrip(Trip trip){
        trip.setTripUser(this);
        trips.add(trip);
    }

    public void addInvitedTrip(Trip trip){
        invitedTrips.add(trip);
    }
    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }


    public List<Trip> getConfirmedTrips() {
        return confirmedTrips;
    }

    public void setConfirmedTrips(List<Trip> confirmedTrips) {
        this.confirmedTrips = confirmedTrips;
    }
    public List<Accessory> getAccessories() {
        return accessories;
    }
    public void addAccessory(Accessory accessory){
        accessories.add(accessory);
    }
    public void removeAccessory(Accessory accessory){
            accessories.remove(accessory);
        }
    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public void confirmParticipation(Trip trip){
        confirmedTrips.add(trip);
        invitedTrips.remove(trip);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31 * (getFirstName() != null ? getFirstName().hashCode() : 0);
        result += 31 * (getLastName() != null ? getLastName().hashCode() : 0);
        result += 31 * (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result += 17 * (getPhoneNumber() != null ? phoneNumber.hashCode() : 0);
        result += 31 * (getEmail() != null ? getEmail().hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TripUser user = (TripUser) obj;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dob = "";
        String userdob = "";

        try {
            dob = sdf.format(dateOfBirth);
            userdob = sdf.format(user.dateOfBirth);
        } catch (NullPointerException e) {
            System.out.println("Nullpointer: " + e.getMessage());
        }

        return !(firstName != null ? !firstName.equals(user.getFirstName()) : user.getFirstName() != null)
                && !(lastName != null ? !lastName.equals(user.getLastName()) : user.getLastName() != null)
                && !(dob != null ? !dob.equals(userdob) : userdob != null)
                && !(email != null ? !email.equals(user.getEmail()) : user.getEmail() != null);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " ";
    }

    public static TripUser INVALID_USER() {
        return new NullUser();
    }


}
