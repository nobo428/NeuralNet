import java.util.Scanner;

public class Demo {
	public static void main(String[] args){
		//init network size variables
		final int OUTPUTS = 1;
		final int INPUTS = 2;
		int depth = 2;
		int hidden = 1;
		float learnRate = (float) 0.1;
		//init training variables
		int trainIter = 1000;
		float peCutoff = (float) 0.05;
		int loopTest = 0;
		
		//init training data for XOR
		float[] in = {1,0};
                float[] out = {1};
		float[] in1 = {0,1};
                float[] out1 = {1};
		float[] in2 = {1,1};
                float[] out2 = {0};
		float[] in3 = {0,0};
                float[] out3 = {0};

		//init variables for network selection based on avg error from
		//last 4 training iterations (all cases of XOR)
		float[] last4Error = new float[4];
		float sumL4E;
		float L4AvgE;

		//init input scanner
		Scanner kb = new Scanner(System.in);
		
		//Ask & assign the variables!
		System.out.println("Welcome to the XOR ANN creator! this program allows you to create networks of different sizes and attempt too train them on the XOR logic table.");
		System.out.println("Please enter the following:");
		
		do {	
			System.out.print("Number of hidden layers: ");
			hidden = kb.nextInt();
		
			System.out.print("Depth of hidden layers: ");
			depth = kb.nextInt();

			System.out.print("Learning rate (0 to 1; try 0.1 for default): ");
			learnRate = kb.nextFloat();

			System.out.print("Number of training iterations per network: ");
			trainIter = kb.nextInt();

			System.out.print("Acceptable maximum error: ");
			peCutoff = kb.nextFloat();

			//create network based on inputs
			Net daNet = new Net(INPUTS, hidden, depth, OUTPUTS, learnRate);	
		
			//init tracker to stop infinite loop
			int tracker = 1;		
			
			//loop until satisfactory net found OR 100 nets failed
			do{	
				//reset with void neurons & random weights
				daNet.populate();
			
				//train network in loop up to trainIter, tracking the error of
				//last 4 iterations (each case of XOR)
				sumL4E = 0;
				for (int i = 0; i < trainIter; i++){
					last4Error[0] = daNet.train(in, out);
					last4Error[1] = daNet.train(in1, out1);
					last4Error[2] = daNet.train(in2, out2);
					last4Error[3] = daNet.train(in3, out3);
				}
				
				//get average error over last 4
				for (float value : last4Error){
					sumL4E += value;
				}
				L4AvgE = sumL4E / 4;
			
				//print average error of each net trained
				System.out.print("Net " + tracker + " avg. error:");
				System.out.println(L4AvgE + "\n");

				//track nets created
				tracker++;
	
			} while (L4AvgE > peCutoff && tracker <= 100);
		
			//if loop exits before tracker timed out...
			if (tracker <= 100) {
				System.out.println("Success! Network " + tracker + " passed the maximum % error cutoff of " + peCutoff);
				System.out.println("Testing XOR...");
			
				//test each case of XOR
				daNet.test(in3);
                		daNet.test(in1);
             		   	daNet.test(in2);
                		daNet.test(in);

				System.out.println("Test another network? Enter 1 for yes, 0 for no.");
				loopTest = kb.nextInt();
			} else {
				//print failure message
				System.out.println("Failure! None of the networks were able to learn XOR given the parameters.");
				System.out.println("Test another network? Enter 1 for yes, 0 for no.");
				loopTest = kb.nextInt();
			}
		} while (loopTest == 1);
	}
}
