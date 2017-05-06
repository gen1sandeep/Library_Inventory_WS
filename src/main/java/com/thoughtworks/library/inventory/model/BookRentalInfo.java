package com.thoughtworks.library.inventory.model;

public class BookRentalInfo {

	
	String isbn;
	String bookId;
	String bookStatus;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	@Override
	public String toString() {
		return "BookRentalInfo [isbn=" + isbn + ", bookId=" + bookId + ", bookStatus=" + bookStatus + "]";
	}
	
}
