/**
 * 
 */
package com.trades.rest.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Siddharth
 *
 */

@Entity
@Table(name = "Trade")
public class Trade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long id;
	private String tradeId;
	private long version;
	private String counterPartyId;
	private String bookId;	
	private String maturityDate;
	private String createdDate;	
	private Character expired;
    
    public Trade() {
    	
	}
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Character getExpired() {
		return expired;
	}
	public void setExpired(Character expired) {
		this.expired = expired;
	}
    
    
    

	

}
