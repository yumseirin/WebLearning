package vo;

import java.sql.Timestamp;

/**
 * 预定会议实体类
 * 
 * @author seirin
 * 
 */
public class Meeting {
	private Integer meetingid; // 预定会议id
	private String meetingname; // 会议名称
	private Integer meetingpersonnum; // 会议参加人数
	private Timestamp meetingstarttime; // 会议开始时间
	private Timestamp meetingendtime; // 会议结束时间
	private Timestamp reservetime; // 会议预定时间
	private Integer roomid; // 会议室id
	private String meetingremark; // 会议说明
	// private Integer[] meetinguserid; // 会议参加者id
	private Integer reserveuserid; // 会义预定人的id
	private Integer meetingstatus; // 会议状态
	private Timestamp canceledtime; // 取消时间
	private String canceledreason; // 取消原因
	private String roomname;	                //会议室名称
	private String realname; 

	public Meeting() {
		super();
	}

	public Meeting(Integer meetingid, String meetingname,
			Integer meetingpersonnum, Timestamp meetingstarttime,
			Timestamp meetingendtime, Timestamp reservetime, Integer roomid,
			String meetingremark, Integer reserveuserid, Integer meetingstatus,
			Timestamp canceledtime) {
		super();
		this.meetingid = meetingid;
		this.meetingname = meetingname;
		this.meetingpersonnum = meetingpersonnum;
		this.meetingstarttime = meetingstarttime;
		this.meetingendtime = meetingendtime;
		this.reservetime = reservetime;
		this.roomid = roomid;
		this.meetingremark = meetingremark;
		this.reserveuserid = reserveuserid;
		this.meetingstatus = meetingstatus;
		this.canceledtime = canceledtime;
	}

	public Meeting(String meetingname, Integer meetingpersonnum,
			Timestamp meetingstarttime, Timestamp meetingendtime,
			Timestamp reservetime, Integer roomid, String meetingremark,
			Integer reserveuserid) {
		super();
		this.meetingname = meetingname;
		this.meetingpersonnum = meetingpersonnum;
		this.meetingstarttime = meetingstarttime;
		this.meetingendtime = meetingendtime;
		this.reservetime = reservetime;
		this.roomid = roomid;
		this.meetingremark = meetingremark;
		this.reserveuserid = reserveuserid;
	}

	
	
	public Meeting(Integer meetingid, String meetingname,
			Integer meetingpersonnum, Timestamp meetingstarttime,
			Timestamp meetingendtime, Timestamp reservetime, Integer roomid,
			String meetingremark, Integer reserveuserid, Integer meetingstatus,
			Timestamp canceledtime, String roomname, String realname) {
		super();
		this.meetingid = meetingid;
		this.meetingname = meetingname;
		this.meetingpersonnum = meetingpersonnum;
		this.meetingstarttime = meetingstarttime;
		this.meetingendtime = meetingendtime;
		this.reservetime = reservetime;
		this.roomid = roomid;
		this.meetingremark = meetingremark;
		this.reserveuserid = reserveuserid;
		this.meetingstatus = meetingstatus;
		this.canceledtime = canceledtime;
		this.roomname = roomname;
		this.realname = realname;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;
	}

	public String getMeetingname() {
		return meetingname;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public Integer getMeetingpersonnum() {
		return meetingpersonnum;
	}

	public void setMeetingpersonnum(Integer meetingpersonnum) {
		this.meetingpersonnum = meetingpersonnum;
	}

	public Timestamp getMeetingstarttime() {
		return meetingstarttime;
	}

	public void setMeetingstarttime(Timestamp meetingstarttime) {
		this.meetingstarttime = meetingstarttime;
	}

	public Timestamp getMeetingendtime() {
		return meetingendtime;
	}

	public void setMeetingendtime(Timestamp meetingendtime) {
		this.meetingendtime = meetingendtime;
	}

	public Timestamp getReservetime() {
		return reservetime;
	}

	public void setReservetime(Timestamp reservetime) {
		this.reservetime = reservetime;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public String getMeetingremark() {
		return meetingremark;
	}

	public void setMeetingremark(String meetingremark) {
		this.meetingremark = meetingremark;
	}

	public Integer getReserveuserid() {
		return reserveuserid;
	}

	public void setReserveuserid(Integer reserveuserid) {
		this.reserveuserid = reserveuserid;
	}

	public Integer getMeetingstatus() {
		return meetingstatus;
	}

	public void setMeetingstatus(Integer meetingstatus) {
		this.meetingstatus = meetingstatus;
	}

	public Timestamp getCanceledtime() {
		return canceledtime;
	}

	public void setCanceledtime(Timestamp canceledtime) {
		this.canceledtime = canceledtime;
	}

	public String getCanceledreason() {
		return canceledreason;
	}

	public void setCanceledreason(String canceledreason) {
		this.canceledreason = canceledreason;
	}

}
