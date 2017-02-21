package kumpul.akses_merakv2;

import java.security.Timestamp;

/**
 * Created by ErwinKok on 21-02-17.
 */

public class TriggerCheck {
    private String memberId;
    private String spaceId;
    private String ID;
    private Long beginAt;
    private Long _createdAt;
    private Long _modifiedAt;
    private Long _rBeginAt;
    private Long duration;
    private Long endAt;

    public TriggerCheck() {}

    public TriggerCheck(String memberId, String ID) {
        this.memberId = memberId;
        this.ID = ID;
        this.beginAt = System.currentTimeMillis();
        this._createdAt = System.currentTimeMillis();
        this._modifiedAt = System.currentTimeMillis();
        this._rBeginAt = (System.currentTimeMillis()) * -1;
    }

    /* GETTERS */
    public String getMemberId() {return memberId;}
    public String getSpaceId() {return spaceId;}
    public String getID() {return ID;}
    public Long getBeginAt() {return beginAt;}
    public Long get_createdAt() {return _createdAt;}
    public Long get_modifiedAt() {return _modifiedAt;}
    public Long get_rBeginAt() {return _rBeginAt;}
    public Long getDuration() {return duration;}
    public Long getEndAt() { return endAt; }

    /* SETTERS */
    public void setMemberId(String memberId) {this.memberId = memberId;}
    public void setSpaceId(String spaceId) {this.spaceId = spaceId;}
    public void setID(String ID) {this.ID = ID;}
    public void setBeginAt(Long beginAt) {this.beginAt = beginAt;}
    public void set_createdAt(Long _createdAt) {this._createdAt = _createdAt;}
    public void set_modifiedAt(Long _modifiedAt) {this._modifiedAt = _modifiedAt;}
    public void set_rBeginAt(Long _rBeginAt) {this._rBeginAt = _rBeginAt;}
    public void setDuration(Long duration) {this.duration = duration;}
    public void setEndAt(Long endAt) {this.endAt = endAt;}
}
