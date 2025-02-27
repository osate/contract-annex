package 'COTS Hardware Library' {

	private import AADL::*;
	private import AADL_Project::* ;
	
	doc
	/* This package models a collection of COTS components */
	
	part def i2c_b :> Bus;
	port def i2c_p :> BusAccess { :> type : i2c_b; }
	
	part def STM32F405_p :> Processor {
		port i2c : i2c_p;
	
		:> Scheduling_Protocol = POSIX_1003_HIGHEST_PRIORITY_FIRST_PROTOCOL;
	}
	
	part def nRF51822_p :> Processor {}
	
	part def MPU9250_d :> Device {
		port i2c : i2c_p;
						
		:> Dispatch_Protocol = Periodic;
		:> Period = 10 [milli * s];
	}
	
	part def PWM_Rate :> Data {}
	
	part def Propellers :> Device {
		port Rate : EventDataPort { in :>> type : PWM_Rate; }
		
	}
	
	
	
}