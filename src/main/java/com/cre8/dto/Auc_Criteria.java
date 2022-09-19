package com.cre8.dto;

public class Auc_Criteria {

	private int currentPage;
	private int rowPerPage = 3;
	private String category;
	private String key;
	
		
		public Auc_Criteria() {
			super();
		}

		public Auc_Criteria(int currentPage) {
			super();
			this.currentPage = currentPage;
		}


		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public int getCurrentPage() {
			return currentPage;
		}



		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}



		public int getRowPerPage() {
			return rowPerPage;
		}



		public void setRowPerPage(int rowPerPage) {
			this.rowPerPage = rowPerPage;
		}



	

}
