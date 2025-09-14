package com.testing;

import org.testng.annotations.Test;

public class GroupingClass {
	
	@Test(priority=2,groups="BACHELORS")
	
	private void bTech() {

		System.out.println("B.Tech");
	}
	
   @Test(priority=8,groups="BACHELORS")
	
	private void mechcanical() {

		System.out.println("Mechcanical");
	}
   
   @Test(priority=7,groups="BACHELORS")
	
	private void civil() {

		System.out.println("Civil");
	}
   
   @Test(priority=5,groups="BACHELORS")
	
	private void software() {

		System.out.println("SoftWare");
	}

   @Test(priority=6,groups="MASTERS")
	
	private void mca() {

		System.out.println("MCA");
	}
	
  @Test(priority=4,groups="MASTERS")
	
	private void mba() {

		System.out.println("MBA");
	}
  
  @Test(priority=3,groups="MASTERS")
	
	private void mphil() {

		System.out.println("M.Phil");
	}
  
  @Test(priority=1,groups="MASTERS")
	
	private void msc() {

		System.out.println("M.sc");
	}

}
