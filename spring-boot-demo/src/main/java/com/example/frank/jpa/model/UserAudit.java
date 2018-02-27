package com.example.frank.jpa.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*    can create a view and access it via view_USERAudit and do the between java  or JPA query
select  ua.uuid, ua.userid, count(ua.uuid) numbergamesplayed
	from useraudit ua
	left join user_login_audit ula
    on ua.uuid= ula.uuid
    and ula.logintime  = DATE(NOW() - INTERVAL 1 DAY)
group by ua.uuid,ua.userid order by numbergamesplayed  desc

 */


@Data
@Entity
@Table(name = "useraudit")
public class UserAudit implements Serializable {

    @Id
    @Column(name="userauditid",length=15, nullable=false)
    private int userAuditID;

    @Column(name="userid",length=15, nullable=false)
    private String userID;

    @Column(name="gameid",length=15, nullable=false)
    private String gameID;

    @Column(name="uuid",length=45, nullable=false)
    private String uuid; // this is uniqueId for each session

    public UserAudit() {}

    public UserAudit(int userAuditID, String userID, String gameID, String uuid) {
        this.userAuditID = userAuditID;
        this.userID = userID;
        this.gameID = gameID;
        this.uuid = uuid;
    }
}
