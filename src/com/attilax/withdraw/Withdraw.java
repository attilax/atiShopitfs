package com.attilax.withdraw;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * com.attilax.withdraw.Withdraw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "withdraw", catalog = "iwmshopnow")
public class Withdraw implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private Double amount;
	private String acc;
	private Timestamp addtime;
	private String bankName;
	private Timestamp processTime;
	private String processRetult;
	private Integer processorId;
	private String processor;
	private String uname;
	private String realname;
	private String bankType;
	private String bankcity;

	// Constructors

	/** default constructor */
	public Withdraw() {
	}

	/** full constructor */
	public Withdraw(Integer uid, Double amount, String acc, Timestamp addtime,
			String bankName, Timestamp processTime, String processRetult,
			Integer processorId, String processor, String uname,
			String realname, String bankType, String bankcity) {
		this.uid = uid;
		this.amount = amount;
		this.acc = acc;
		this.addtime = addtime;
		this.bankName = bankName;
		this.processTime = processTime;
		this.processRetult = processRetult;
		this.processorId = processorId;
		this.processor = processor;
		this.uname = uname;
		this.realname = realname;
		this.bankType = bankType;
		this.bankcity = bankcity;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "uid")
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "amount", precision = 10, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "acc")
	public String getAcc() {
		return this.acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	@Column(name = "addtime", length = 19)
	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	@Column(name = "bank_name")
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "process_time", length = 19)
	public Timestamp getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(Timestamp processTime) {
		this.processTime = processTime;
	}

	@Column(name = "process_retult")
	public String getProcessRetult() {
		return this.processRetult;
	}

	public void setProcessRetult(String processRetult) {
		this.processRetult = processRetult;
	}

	@Column(name = "processor_id")
	public Integer getProcessorId() {
		return this.processorId;
	}

	public void setProcessorId(Integer processorId) {
		this.processorId = processorId;
	}

	@Column(name = "processor")
	public String getProcessor() {
		return this.processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Column(name = "uname")
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "realname")
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "bank_type")
	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	@Column(name = "bankcity")
	public String getBankcity() {
		return this.bankcity;
	}

	public void setBankcity(String bankcity) {
		this.bankcity = bankcity;
	}

}