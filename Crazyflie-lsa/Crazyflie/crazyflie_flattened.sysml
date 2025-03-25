package Crazyflie_Flattened {

	private import AADL::*;
	
	private import 'COTS Hardware Library'::*;
	private import '3. Crazyflie Software'::*;
	
	/* Same as Crazflie_Platform_2, but with the type hierarchy flattend. */	 
	 part def Crazyflie_Platform_Flattened :> System {
	 	part MPU9250   : MPU9250_d;
	 	part STM32F405 : STM32F405_p;
	 	part nRF51822  : nRF51822_p;
	 
		part i2c : i2c_b;	
		part props : Propellers[4];
	 	
	 	connection C1 : AccessConnection 
		 	connect STM32F405.i2c to i2c;	 	

		part STM32F405_Firmare_i : STM32F405_Firmware_Impl;
		part nRF51822_Firmware_i : nRF51822_Firmware;
			
		connection C2 : PortConnection
			connect  nRF51822_Firmware_i.Syslink_Packet_RX to STM32F405_Firmare_i.Syslink_Packet_TX;
			
		connection C3 : PortConnection
			connect  nRF51822_Firmware_i.Syslink_Packet_TX to STM32F405_Firmare_i.Syslink_Packet_RX;

		allocation a1 : Deployment_Properties::Actual_Processor_Binding {
			end part sw ::> STM32F405_Firmare_i.CRTP_Tx_Task;
			end part hw references STM32F405;
		}
		allocation a2 : Deployment_Properties::Actual_Processor_Binding
			allocate sw ::> STM32F405_Firmare_i.CRTP_Rx_Task
			to hw ::> STM32F405;
		allocation a3 : Deployment_Properties::Actual_Processor_Binding
			allocate sw references STM32F405_Firmare_i.Power_Management
			to hw ::> STM32F405;
		allocation a4 : Deployment_Properties::Actual_Processor_Binding
			allocate sw ::> STM32F405_Firmare_i.Main_Loop
			to hw ::> STM32F405;
	 }
}