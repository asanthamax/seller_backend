package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;

    public SystemUser() {
    }

    public SystemUser(String firstName, String lastName, String email, String mobileNo, String profilePicture, String userName, String password, String userResetKey, Date createdDate, Date modifiedDate, int isActive, String userRole, String regToken, int isVerify) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;

        this.profilePicture = profilePicture;
        this.userName = userName;
        this.password = password;
        this.userResetKey = userResetKey;
        this.createdDate = new Date(createdDate.getTime());
        this.modifiedDate = new Date(modifiedDate.getTime());
        this.isActive = isActive;
        this.userRole = userRole;
        this.regToken = regToken;
        this.isVerify = isVerify;
    }

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserResetKey() {
        return userResetKey;
    }

    public void setUserResetKey(String userResetKey) {
        this.userResetKey = userResetKey;
    }

    public Date getCreatedDate() {
        return new Date(createdDate.getTime());
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = new Date(createdDate.getTime());
    }

    public Date getModifiedDate() {
        return new Date(modifiedDate.getTime());
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = new Date(modifiedDate.getTime());
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getRegToken() {
        return regToken;
    }

    public void setRegToken(String regToken) {
        this.regToken = regToken;
    }

    public int getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(int isVerify) {
        this.isVerify = isVerify;
    }

    @Column(name = "mobileNo", nullable = false)
    private String mobileNo;

    @Column(name = "profilePicture")
    private String profilePicture;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "userResetKey")
    private String userResetKey;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "modifiedDate", nullable = false)
    private Date modifiedDate;

    @Column(name = "isActive", nullable = false)
    private int isActive;

    @Column(name = "userRole", nullable = false)
    private String userRole;

    @Column(name = "regToken")
    private String regToken;

    @Column(name = "isVerify", nullable = false)
    private int isVerify;

}
