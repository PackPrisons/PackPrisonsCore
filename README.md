# PackPrisonsCore
The core plugin for PackPrisons

What does this plugin include?

- Private Message System
- Essential Commands
- Punishment System
- Essential Events
- Store Interigation
- Auction House
- Gang/Drugs System
- and so much more!

How to create and register commands:
- Extend ``PackCommand`` instead of implementing ``CommandExecutor`` when creating commands
- The parent class ``PackCommand`` needs a ``label``, ``minimumArguments``, ``maximumArguments``, and ``permission`` when calling the Parent Class Constructor
- Create a ``new instance`` of the command class in the ``registerCommands()`` method in order to register a Command

Definitions:
- ``label`` - The name of the Command
- ``minArgs`` - The minimum amount of arguments the Command will have
- ``maxArgs`` - The maximum amount of arguments the Command will have 
- ``permission`` - The permission needed in order to run the Command

