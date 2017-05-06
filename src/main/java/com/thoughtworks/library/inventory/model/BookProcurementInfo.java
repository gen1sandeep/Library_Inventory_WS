package com.thoughtworks.library.inventory.model;

public class BookProcurementInfo {

	String isbn;
	String shelfDetails;
	String bookTitle;
	String bookId;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
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
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	@Override
	public String toString() {
		return "BookProcurementInfo [bookId=" + bookId + ", isbn=" + isbn + ", shelfDetails=" + shelfDetails
				+ ", bookTitle=" + bookTitle + "]";
	}
	
	
}
