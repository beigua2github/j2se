package multiThread;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 项目entity
 */
@Data
@Builder
public class ProjectOrderDto {
    private int id;
    private String partyId;
    private String username;
    private String orderId;
    private int orderAmount;
    private int totalAmount;
    private int amount;
    private int tax;
    private Date createTime;
    private Date censorTime;
    private String operatorId;
    private String operatorName;
    private String transferChannel;
    private String transferAcc;
    private String transferNo;
    private Date completedTime;
    private String paidResult;
}
