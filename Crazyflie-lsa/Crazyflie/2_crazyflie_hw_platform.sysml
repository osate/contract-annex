package '2. Crazyflie HW Platform' {

	private import AADL::*;
	
	private import '1. Crazyflie Functional'::*;
	private import 'COTS Hardware Library'::*;
	
	doc
	/*  
 	 * This package models the hardware platform of the Crazyflie,
 	 * from https://wiki.bitcraze.io/doc:crazyflie:dev:fimware:sensor_to_control
 	 * 
 	 * At this stage, this is an abstract platform, missing key elements such as 
 	 * power management, frame, etc.
	 *
	 */
	 
	 part def Crazyflie_Platform :> System {
	 	part MPU9250   : MPU9250_d;
	 	part STM32F405 : STM32F405_p;
	 	part nRF51822  : nRF51822_p;
	 
		part i2c : i2c_b;	
		part props : Propellers[4];
	 	
	 	connection C1 : AccessConnection 
		 	connect STM32F405.i2c to i2c;	 	
	 }
	 
	 package Functional_to_HW_Platform {
		part crazyflie_platform : Crazyflie_Platform;
	 	part crazyflie_functional : Crazyflie_Functional_Chain;
	 
		allocate crazyflie_functional to crazyflie_platform {
			allocate crazyflie_functional.Acc to crazyflie_platform.MPU9250;
		 	allocate crazyflie_functional.Gyr to crazyflie_platform.MPU9250;
		 	allocate crazyflie_functional.Mag to crazyflie_platform.MPU9250;
		 	allocate crazyflie_functional.Fus to crazyflie_platform.MPU9250;
		 	
		 	allocate crazyflie_functional.Con to crazyflie_platform.STM32F405;
		 	
		 	allocate crazyflie_functional.Mot to crazyflie_platform.props;
		 }	
	 }
}