XOR NeuralNet Generator
=======================
![net](https://www.pngitem.com/pimgs/m/531-5314899_artificial-neural-network-png-transparent-png.png "netLogo")
 
 Introduction
 ------------
 
The XOR NeuralNet Generator creates backpropogating artificial neural networks to solve the XOR truth table!
It creates 100 networks and attempts to train them, based on the network size and training information provided by the user.
 
Features
--------

- __Creates up to 100 backpropogating neural networks__
- __Creates networks of any size__
- __Adjustable learning rate__
- __Trains each network for a user-set number of iterations__
- __Searches for network that operates below a desired error threshold after training__

Description of Equipment
------------------------
- Computer
- Linux terminal application
- Java
    -  To check your version of java, execute in terminal:
    
            javac --version
- XOR NeuralNet Generator
    - *see installation instructions below!*
 
Installation
------------
 
1. Open your linux terminal application
2. Navigate to desired installation directory
3. Install XOR NeuralNet Generator by running:
 
        git clone https://github.com/nobo428/XOR-NeuralNet-Generator.git

    while in desired directory.
 
Using the Program
-----------------

*__Upon initial installation, execute the following commands from inside the cloned repository:__*

    make clean
    make compile
    
*__From then on, use the 'make start' to start the program:__*
    
    make start
    
__When prompted, enter the desired parameters for the network you would like to create.__

    Welcome to the XOR ANN creator! this program allows you to create networks of different sizes and attempt too train them on the XOR logic table.

*__To enter a desired value, type the value and press the 'enter' key.__*

    Please enter the following:

1. __Number of Hidden Layers__
    
        Number of hidden layers:
    
    This value corresponds to the quantity of hiddden layers in the network. More layers creates a longer chain of neurons for analysis.
2. __Depth of Hidden Layers__

        Depth of hidden layers: 

    The depth of the hidden layers is how many neurons are in each layer. A greater depth will create a network with more paths of deduction.
3. __Learning Rate__

        Learning rate (0 to 1; try 0.1 for default): 

    The learning rate is a value between 0 and 1 that affects the magnitude by which the algorithm adjusts its synaptic weights each training iteration. Try 0.1 to start!
4. __Training Iterations__

        Number of training iterations per network: 

    This input dictates how many times each generated network will be trained on the training data before being tested for error.
5. __Maximum Error__

        Acceptable maximum error: 
 
    This value dictates what is an acceptable network by the program; only a network with an average error of less than this value will be accepted. 
    Measured in decimal percentage; 0.1 for 10%, 0.01 for 1%, 0.005 for 0.5% etc.
    
__Example Results__
- Successfully made network that satisfies criteria:
        
        Success! Network 70 passed the maximum % error cutoff of 0.05
        Testing XOR...
        Input 1 : 0.0
        Input 2 : 0.0
        Result 1: 0.044054687

        Input 1 : 0.0
        Input 2 : 1.0
        Result 1: 0.96445936

        Input 1 : 1.0
        Input 2 : 1.0
        Result 1: 0.050144732

        Input 1 : 1.0
        Input 2 : 0.0
        Result 1: 0.970499

        Test another network? Enter 1 for yes, 0 for no.
        
- Failed to create network that meets criteria:

        Failure! None of the networks were able to learn XOR given the parameters. 
        Test another network? Enter 1 for yes, 0 for no.
        
__In either case, enter 1 to run the program again with new values or 0 to exit.__
    
FAQs
----

*__What is the XOR truth table?__*
It is the exclusive or, a classic and simple logical proposition that the computer can be trained to learn on its own. Given two inputs of either 1 or 0, the program will output 1 if the inputs are different, and 0 if both inputs are the same. See:

     In    Out
    [0, 0] [0]
    [1, 0] [1]
    [0, 1] [1]
    [1, 1] [0]

*__What kind of activation algorithm do the networks use?__*
The hidden-layer neurons use the hyperbolic tangent activation function (tanh), while the outputs use the rectified linear units function (reLU).

*__How are the synaptic weights initialized?__*
The majority use the Xavier weight initialization method, while the last layer of connections to the outputs uses the He weight initialization method.

*__Why do so many networks fail to learn XOR?__*
Due to the variablility in network size and shape, it is relatively easy for these networks to get caught in local minima when trying to reduce their error. This likelihood of failure is why the program creates many networks and monitors their average error before accepting a network.

Contribution
----------
 
- __Issue Tracker:__ https://github.com/nobo428/XOR-NeuralNet-Generator/issues
- __Source Code:__ https://github.com/nobo428/XOR-NeuralNet-Generator
 
Support / Troubleshooting
-------
 
If you are having issues, please let me know!
*Email me at:* bodinnb@appstate.edu
 
Licensing
-------
 
The project will be licensed under the __MIT__ license.
