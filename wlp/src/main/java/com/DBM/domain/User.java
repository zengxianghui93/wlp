package com.DBM.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_user")
public class User extends BaseDomain {
    /**
     *锁定用户对应的状态值 
     */
    public static final int USER_LOCK = 1;
    /**
     * 用户解锁对应的状态值
     */
    public static final int USER_UNLOCK = 0;
    /**
     * 超级管理员类型
     */
    public static final int SUPER_ADMIN = 3;
    /**
     * 内容管理员类型
     */
    public static final int FORUM_ADMIN = 2;
    /**
     * 技术经纪人用户类型
     */
    public static final int JJR_USER = 1;
    /**
     * 普通用户类型
     */
    public static final int NORMAL_USER = 0;
    /*
     * 用户id
     */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private int userId;
    /*
     * 用户名
     */
    @Column(name = "user_name")
	private String userName;
    
    /*
     * 创建时间
     */
    @Column(name = "create_time")
	private Date createTime;
    
    /*
     * 用户真实姓名
     */
    @Column(name = "name")
	private String name;
   
    /*
     * 用户邮箱
     */
    @Column(name = "email")
	private String email;
    
    /*
     * 登录时间
     */
	@Column(name = "last_visit")
	private Date lastVisit;
	
	/*
     * 最后ip
     */
    @Column(name = "last_ip")
	private String lastIp;
    
    /*
     * 用户性别
     */
    @Column(name = "user_sex")
    private int userSex;
    
    /*
     * 用户电话
     */
	@Column(name = "phone")
	private String phone;
	
	 /*
     * 出生日期 
     */
    @Column(name = "birthday")
    private String birthday ;
    
    /*
     *所属部门
     */
    @Column(name = "department")
    private String  department;
    
    /*
     * 职务
     */
    @Column(name = "duty")
    private String duty ;
    
    /*
     * 学历
     */
    @Column(name = "education")
    private String education ;
    
    /*
     * 照片(图片)
     */
    @Column(name = "picture")
	private String picture;
    /*
     * 用户类型
     */
    @Column(name = "user_type")
    private int userType ;
    /*
     * 用户地址
     */
    @Column(name = "user_address")
    private String user_address ;
    /*
     * 邮政编码
     */
    @Column(name = "postcode")
    private String postcode ;
   
    /*
     * 职称
     */
    @Column(name = "professional")
    private String  professional ;
  
    /*
     * 行业
     */
    @Column(name = "industry")
    private String industry ;
    /*
     * 单位名称
     */
    @Column(name = "enterprisename")
    private String  enterprisename;
    
    /*
     *所属集团
     */
    @Column(name = "groups")
    private String  groups;
    
    /*
     * ip范围
     */
    @Column(name = "scope_ip")
	private String scope_ip;
    
	private String password;

	private int locked;

	private int credit;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "t_board_manager", joinColumns = {@JoinColumn(name ="user_id" )}, inverseJoinColumns = {@JoinColumn(name = "board_id") })
	private Set<Board> manBoards = new HashSet<Board>();
    
    /**
     * 云平台用户类型
     */
    @Column(name = "power")
    private String power;
    
    /**
     * 云平台授权起始时间
     */
    @Column(name = "authorizeStartTime")
    private Date authorizeStartTime;
    
    /**
     * 云平台授权截止时间
     */
    @Column(name = "authorizeEndTime")
    private Date authorizeEndTime;
    
 	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getEnterprisename() {
		return enterprisename;
	}

	public void setEnterprisename(String enterprisename) {
		this.enterprisename = enterprisename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getScope_ip() {
		return scope_ip;
	}

	public void setScope_ip(String scope_ip) {
		this.scope_ip = scope_ip;
	}

	public String getPhone() {
 		return phone;
 	}

 	public void setPhone(String phone) {
 		this.phone = phone;
 	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}
	
	public Set<Board> getManBoards()
    {
        return manBoards;
    }

    public void setManBoards(Set<Board> manBoards)
    {
        this.manBoards = manBoards;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Date getAuthorizeStartTime() {
		return authorizeStartTime;
	}

	public void setAuthorizeStartTime(Date authorizeStartTime) {
		this.authorizeStartTime = authorizeStartTime;
	}

	public Date getAuthorizeEndTime() {
		return authorizeEndTime;
	}

	public void setAuthorizeEndTime(Date authorizeEndTime) {
		this.authorizeEndTime = authorizeEndTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	


}
