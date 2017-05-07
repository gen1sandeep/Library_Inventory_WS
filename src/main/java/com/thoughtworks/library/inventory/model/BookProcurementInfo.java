package com.thoughtworks.library.inventory.model;

public class BookProcurementInfo {

	/**
	 * Empty constructor
	 */
	public BookProcurementInfo() {
	}

	private long bookId;
	private String isbn;
	private String bookStatus;
	private String shelfDetails;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getShelfDetails() {
		return shelfDetails;
	}

	public void setShelfDetails(String shelfDetails) {
		this.shelfDetails = shelfDetails;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return "BookProcurementInfo [isbn=" + isbn + ", shelfDetails=" + shelfDetails + ", bookStatus=" + bookStatus
				+ ", bookId=" + bookId + "]";
	}

}
