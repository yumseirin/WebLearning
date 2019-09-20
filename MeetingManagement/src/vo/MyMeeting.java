package vo;

import java.sql.Timestamp;
/**
 * 我的会议实体类
 * @author seirin
 *
 */
public class MyMeeting {
	  private Integer meetingid;   				//预定会议id
	  private String meetingname;   			//会议名称
	  private Integer meetingpersonnum; 		//会议参加人数
	  private Timestamp meetingstarttime;		//会议开始时间
	  private Timestamp meetingendtime;			//会议结束时间
	  private Timestamp reservetime;            //会议预定时间
	  private Integer  roomid;                  //会议室id
	  private String meetingremark;             //会议说明
	  private String meetinguserid;             //会议参加者
	  private Integer reserveuserid;            //会讲义预定人的id
	  private Integer meetingstatus;            //会议状态
	  private String roomname;	                //会议室名称
	  private String realname; 		            //员工真实姓名
	  
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
	public String getMeetinguserid() {
		return meetinguserid;
	}
	public void setMeetinguserid(String meetinguserid) {
		this.meetinguserid = meetinguserid;
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

	  
}