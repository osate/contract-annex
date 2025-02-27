package '1. Crazyflie Functional' {

	private import AADL::*;
	public import SI::*;
	
	doc
	/*  
 	 * This package models the abstract functional chain of the Crazyflie,
 	 * from https://wiki.bitcraze.io/doc:crazyflie:dev:fimware:sensor_to_control
	 */

	part plop : Data;

	part def Accelero :> Abstract {
		port Accelero_Out : EventDataPort { :> type = plop;}
		
		:> Dispatch_Protocol = Periodic;
		:> Period = 4 [milli * s];
	}

	part def Gyro :> Abstract {
		port Gyro_Out  : EventDataPort;
		
		:> Dispatch_Protocol = Periodic;
		:> Period = 4 [milli * s];
	}

	part def Magneto :> Abstract {
		port Magneto_Out  : EventDataPort;
		
		:> Dispatch_Protocol = Periodic;
		:> Period = 4 [milli * s];
	}
  
	part def Sensor_Fusion :> Abstract {
		port Accelero_In : DataPort;  	 
		port Gyro_In     : DataPort;
		port Magneto_In  : DataPort;
		port Data_F_Out  : DataPort; 
		
  		:> Dispatch_Protocol = Periodic;
		:> Period = 4 [milli * s];

	}
  
	part def Controller :> Abstract {
		port Data_F_In : DataPort;
		port Gyro_In   : DataPort;
		port Motor_Out : DataPort;
		port TC        : DataPort;
		
		:> Dispatch_Protocol = Periodic;
		:> Period = 2 [milli * s];
		
	}  
  
	part def Motor :> Abstract {
		port Motor_In : DataPort;
		
		:> Dispatch_Protocol = Periodic;
		:> Period = 2 [milli * s];
	
	}
  
	part def Crazyflie_Functional_Chain :> System {
	  	part Acc : Accelero;
	  	part Gyr : Gyro;
	  	part Mag : Magneto;
	  	part Fus : Sensor_Fusion;
	  	part Con : Controller; 
  		part Mot : Motor;
  		
  		connection C1 :PortConnection connect Acc.Accelero_Out to Fus.Accelero_In;
  		connection C2 :PortConnection connect Gyr.Gyro_Out     to Fus.Gyro_In;
  		connection C3 :PortConnection connect Mag.Magneto_Out  to Fus.Magneto_In;
  		connection C4 :PortConnection connect Gyr.Gyro_Out to Con.Gyro_In;
  		connection C5 :PortConnection connect Fus.Data_F_Out to Con.Data_F_In;
  		connection C6 :PortConnection connect Con.Motor_Out to Mot.Motor_In;
  		
  	}
}
  