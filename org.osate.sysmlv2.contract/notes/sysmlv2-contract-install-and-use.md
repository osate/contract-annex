# Notes for Using Contracts with SysMLv2

## Setup/Install for Using Contracts with SysMLv2

Special instructions are necessary for producing a working development environment that merges the OSATE contract language with SysMLv2 modeling capability.  This is because at this time, the default Eclipse used by the standard SysMLv2 pilot implementation installation is 2024-03, but the the XSemantics project used by the contract language depends on Eclipse 2013-12.  

### 1. Create/Obtain a Modified Setup File

A modified `SysML2.setup` file is necessary to force SysMLv2 to be installed on top of Eclipse 2023-12.  A copy of that file can be found [here](./SysML2-for-2023-12.setup)

This file is created by modifying `SysML2.setup`, which is found in the `org.omg.sysml.installer` directory in the Pilot Implementation distribution.  A link that the file is [here](https://github.com/Systems-Modeling/SysML-v2-Pilot-Implementation/blob/master/org.omg.sysml.installer/SysML2.setup).

Line 15 is changed so that the name is now `"sysml-local-for-2023-12"`

Line 16 is changed so that the label is now `"sysml-local-for-2023-12"` 

Lines 45–46 are updated so that the Eclipse 2023-12 release is used:

```
    <repository
        url="http://download.eclipse.org/releases/2023-12/"/>
```

Lines 82–84 are updated so that the task name is changed:

```
  <setupTask
      xsi:type="pde:TargetPlatformTask"
      name="SysMLv2 2023-12 Target"/>
```

### 2. Install the SysMLv2 Pilot Implementation

1. Run the Eclipse Installer
2. Select the "Eclipse Modeling Tools" as the product to install.  Choose product version "2023-12".  Select a Java 17 JVM to use.  Click on "Next >".
3. We have to add the modified SysMLv2 setup file to the list of projects (if you haven't done so before).  Click on the green "+" in the top right to begin the process of adding the file.  In the "Add User Projects" dialog box, choose "Github Projects" as the catalog, and "Browse File System…" to choose the modified setup file.  Click on "Ok".  
4. Select "SysML2-local-for-2023-12" in the list of projects.  Click on "Next >".
5. Customize the installation variables as you like.  Click on "Next >".
6. Click on "Finish" in the Confirmation pane.
7. The Eclipse installer will do its thing, and cause the new Eciipse to launch, which will then execute the setup file for the SysMLv2 Pilot implementation.  _**NOTE:** This will say that the build failed because of something to do with "Juptyer".  This is normal._  Select the projects `jupyter-sysml-kernel`, `org.omg.sysml.interactive`, `org.omg.sysml.interactive.tests`, `org.omg.sysml.jupyter.installer`, and `org.omg.sysml.jupyter.jupyterlab` and close them.  You don't need them.  (Don't delete them from the workspace: the setup file will cause them to be readded next time you open Eclipse.)
8. Bring up the context menu on any one of the SysML projects.  Select `Team > Switch To > Other…`.  In the "Branches" dialog, open up the list of "Tags" and select "2024-12".  Click on "Check Out".  Click "Okay" on the "Detached Head" warning dialog.

### 3. Install XSemantics

1. Go to `Help > Install New Software…`.
2. Click on "Add…" to add a new software site.  In the "Add Respository" dialog box add the location `https://download.eclipse.org/xsemantics/milestones/` with the name `XSemantics`.  Click on "Add".
3. Select "XSemantics 1.24.x" and click on "Next >".
4. Click on "Next >" in the "Install Details" dialog.
5. Accept the license terms and click on "Finish".
6. Restart the IDE when prompted.


### 4. Install EASE

1. Go to `Help > Install New Software…`.
2. Click on "Add…" to add a new software site.  In the "Add Respository" dialog box add the location `https://download.eclipse.org/ease/release/0.9.0` with the name `EASE`.  Click on "Add".
3. Select "EASE Core", "Ease Language Support", and "Ease Modules" and click on "Next >".  The installer will spend a little while computing alternative installation solutions.
4. On the "Install Remediation Page" just click on "Next >" to continue.
5. Click on "Next >" in the "Install Details" dialog.
6. Accept the license terms and click on "Finish".
7. Restart the IDE when prompted.


### 5. Install the Contracts packages (from GitHub)

(This assumes you do not already have a clone of the `contract-annex` repository.  If you already have one you would like to use, you can add it to the "Git Repositories" view.  Make sure you "Switch to…" the branch "contracts-for-lsa".)

1. Got the "Git Perspective" in Eclipse.
2. Copy `git@github.com:osate/contract-annex.git` to the clipboard.
3. Paste into the "Git Repositories" view.  The "Clone Git Repository" dialog box will open.  Select only the "contracts-for-lsa" branch.  Click on "Next >".
4. Bring up the context menu on the "contract-annex" repo.  Select "Import Projects…".  Select the projects `org.osate.sysmlv2.contract`, `org.osate.sysmlv2.contract.evaluation.ui`, `org.osate.sysmlv2.execution`, `org.osate.sysmlv2.contract.ide`, `org.osate.sysmlv2.contract.ui`, `org.osate.sysmlv2.modelsupport`.  Click on "Finish".

 
### 6. Launch the SysMLv2 Environment

1. Bring up the context menu on the project `org.omg.sysml` and select `Run As > Eclipse Application`.
2. Open "Run Configurations…" from the "run" toolbar menu.  Rename the "Eclipse Application" configuration to something else; I used "Contracts for SysMLv2".


## SysMLv2 Example Project

The query support has been tailored to work for the a specific example based on the Crazyflie model.  This model is found in the project `Crazflie-lsa` on the `contracts-for-lsa` branch of the `contract-annex` GIT repo.


## Executing a Verification Plan on a SysMLv2 Model

This process is different from the AADL case because there is not yet an instance-model equivalent for SysMLv2.  Because of this, the `component` clause of a verification plan is actually useful when working with SysMLv2.  It refers to the SysMLv2 part definition that serves as the root of the verification.  For example, the verification plan for the Crazyflie example is 

```
verification plan verifySchedualability {
	component Crazyflie_Flattened::Crazyflie_Platform_Flattened;
	domains
		FlowSynchronizationContract::schedulability; 
	claims
		`And([Deadlines[i] >= Responses[i] for i in range(len(Deadlines))])`;
	contracts
		FlowSynchronizationContract::RMAHarmonicBoundContract;
		FlowSynchronizationContract::RMANonHarmonicBoundContract;
}
```

The verification plan is selected directly for execution in this case, and not the model as is the case for AADL:

1. Open the verification plan `.contract` file.  
2. Bring up the context menu on the verification plan object in the "Outline" view, and select `Analysis Contracts > Execute Verification Plans` or `Analysis Contracts > Check Verification Plan Completeness`.

_**NOTE:** Sometimes the "Outline" view loses synchronization with the actual verification plan model and the execution fails with a null point exception.  Usually this can be fixed by closing the verification plan contract and reopening it._
