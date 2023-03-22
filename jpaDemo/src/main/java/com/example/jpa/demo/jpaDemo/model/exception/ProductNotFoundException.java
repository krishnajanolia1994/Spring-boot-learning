package com.example.jpa.demo.jpaDemo.model.exception;

public class ProductNotFoundException extends Exception{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String error;

		public ProductNotFoundException(String error) {
			super();
			this.error = error;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}
		
		
		
}
