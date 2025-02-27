# Crazyflie Case Study

These SysMLv2 models are a direct translation from AADL models for the Crazyflie UAV available at 
[OpenAADL/Crazyflie](https://github.com/OpenAADL/Crazyflie).

## About

This model has been initially created to demonstrate various capabilities of the AADL language: model structure, analysis (flow latency, schedulability, fault analysis, ...). We translated it to SysMLv2 to exercise the AADL library for SysMLv2 currently under development by the OMG Systems Modeling Community. 

The model captures only the controller structure of the UAV, made of sensors, a control loop and propellers. 

## Structure

This model is organized as follows 
- ```crazyflie_functional.sysml``` captures the functional chain of the UAV,
- ```cots_hw.sysml``` is a collection of COTS hardware components

