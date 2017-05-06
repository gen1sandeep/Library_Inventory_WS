/**
 * 
 */
package com.thoughtworks.library.inventory.model;

/**
 * @author Sandeep_Alla
 *
 */
public class BookAvailabilityInfo {
	
	// no arg constructor required for serialization
	public BookAvailabilityInfo() {
	}
	
	String ISBN;
	int totalBookCount;
	int issuedBookCount;
	int avalilableBookCount;
	int archivedBookCount;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getTotalBookCount() {
		return totalBookCount;
	}
	public void setTotalBookCount(int totalBookCount) {
		this.totalBookCount = totalBookCount;
	}
	public int getIssuedBookCount() {
		return issuedBookCount;
	}
	public void setIssuedBookCount(int issuedBookCount) {
		this.issuedBookCount = issuedBookCount;
	}
	public int getAvalilableBookCount() {
		return avalilableBookCount;
	}
	public void setAvalilableBookCount(int avalilableBookCount) {
		this.avalilableBookCount = avalilableBookCount;
	}
	public int getArchivedBookCount() {
		return archivedBookCount;
	}
	public void setArchivedBookCount(int archivedBookCount) {
		this.archivedBookCount = archivedBookCount;
	}
	@Override
	public String toString() {
		return "BookAvailabilityInfo [ISBN=" + ISBN + ", totalBookCount=" + totalBookCount + ", issuedBookCount="
				+ issuedBookCount + ", avalilableBookCount=" + avalilableBookCount + ", archivedBookCount="
				+ archivedBookCount + "]";
	}

}
