# Installation of Contract Annex support for OSATE

The contract annex support for OSATE consists of the contract annex plug-ins together with a separate installation
of Python and the Z3 library for Python. We have tested the contract annex with Python 3.9, 3.10, and 3.11.

The contract annex OSATE plug-ins can be installed from within OSATE as an additional component via 
_Help_ > _Install Additional OSATE Components._ This brings up a dialog with a list of available components. 
Select "Contract Annex" from the list of SEI Components and click _Finish._ After installation of the pug-ins OSATE must be
re-started.

A Python 3.9, 3.10, or 3.11 interpreter must be installed separately for the underlying operating system. A Python installer can be downloaded
from https://www.python.org/downloads/. **Caution: Python 3.12 will not work.**

The following assumes a Windows 10/11 operating system that is not locked down by an organization specific policy.

Run the installer by double clicking on the downloaded program. In the installer check the option "Add Python 3.x to PATH."
In addition the option to install the py launcher should be checked. After installation start a command window 
(cmd.exe or powershell) and run the command `py`. This should start the Python interpreter and print a welcome message.
Type exit() or Ctrl-Z followed by Return to exit.

The next step is to install the Python package z3-solver using using the pip command, which was installed together with the
Python interpreter. In a command window run

`pip install z3-solver`

In the final step, configure OSATE to use the command `py` to run Python scripts. Start OSATE and go to _Window_ > 
_Preferences_ > _Scripting_ > _Python Scripting (using Py4J)_ , type `py` into the Python location text field and click _Apply and Close_ .
