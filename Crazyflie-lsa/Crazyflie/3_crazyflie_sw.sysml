package '3. Crazyflie Software' {

	private import AADL::*;
	private import '2. Crazyflie HW Platform'::*;
	private import 'COTS Hardware Library'::*;
	
	part def Syslink_Packet :> Data {}
	
	part def nRF51822_Firmware :> Process {
		port Syslink_Packet_TX : EventDataPort { out :>> type : Syslink_Packet; }
	  	port Syslink_Packet_RX : EventDataPort { in :>> type : Syslink_Packet; }
	}

	part def Six_Axis :> Data {}

	part def STM32F405_Firmware :> Process {
		port Syslink_Packet_TX : EventDataPort { out :>> type : Syslink_Packet; }
	  	port Syslink_Packet_RX : EventDataPort { in :>> type : Syslink_Packet; }
	  	
		port DOFs : EventDataPort { in :>> type : Six_Axis; }
		port Rate1 : EventDataPort { out :>> type : PWM_Rate; }
		port Rate2 : EventDataPort { out :>> type : PWM_Rate; }
		port Rate3 : EventDataPort { out :>> type : PWM_Rate; }
		port Rate4 : EventDataPort { out :>> type : PWM_Rate; }	
	}

	part def STM32F405_Firmware_Impl :> STM32F405_Firmware {
		part CRTP_Tx_Task : CRTP_Tx_Task_t;
		part CRTP_Rx_Task : CRTP_Rx_Task_t;
		part Power_Management: Power_Management_t;
		part Main_Loop : Main_Loop_t;
		
		// ignore connections and flows
		
		// bind or allocate threads
	}
	
	part def CRTP_Tx_Task_t :> Thread {
		// Ignore features for now
		
		:>> Priority = 2;
		:>> Dispatch_Protocol = Sporadic;
		:>> Period = 1000 [micro * s];
		:>> Compute_Execution_Time {
			:>> minimum = 10 [micro * s];
			:>> maximum = 50 [micro * s];
		}
	}	

	part def CRTP_Rx_Task_t :> Thread {
		// Ignore features for now
		
		:>> Priority = 2;
		:>> Dispatch_Protocol = Sporadic;
		:>> Period = 1000 [micro * s];
		:>> Compute_Execution_Time {
			:>> minimum = 10 [micro * s];
			:>> maximum = 50 [micro * s];
		}
	}	

	part def Power_Management_t :> Thread {
		:>> Priority = 2;
		:>> Dispatch_Protocol = Periodic;
		:>> Period = 500 [micro * s];
		:>> Compute_Execution_Time {
			:>> minimum = 10 [micro * s];
			:>> maximum = 20 [micro * s];
		}
	}	

	part def Main_Loop_t :> Thread {
		// Ignore features for now
		
		:>> Priority = 3;
		:>> Dispatch_Protocol = Periodic;
		:>> Period = 2000 [micro * s];
		:>> Compute_Execution_Time {
			:>> minimum = 100 [micro * s];
			:>> maximum = 200 [micro * s];
		}
	}	


	part def Crazyflie_Platform_2 :> Crazyflie_Platform  {
		part STM32F405_Firmare_i : STM32F405_Firmware_Impl;
		part nRF51822_Firmware_i : nRF51822_Firmware;
			
		connection C2 : PortConnection
			connect  nRF51822_Firmware_i.Syslink_Packet_RX to STM32F405_Firmare_i.Syslink_Packet_TX;
			
		connection C3 : PortConnection
			connect  nRF51822_Firmware_i.Syslink_Packet_TX to STM32F405_Firmare_i.Syslink_Packet_RX;

	/* Currently there is no instantiation / execution.  How is this going to be handled
	 * with queries?  
	 */

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
		
// XXX Error: why?  Came this way...		
//		connection C4 : PortConnection
//			connect STM32F405_Firmare_i.Rate1 to props[1].Rate;
	}

	
}