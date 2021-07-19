import java.util.Random;

public class Net {
	int numIn, numHid, numDepth, numOut, maxDepth;
	float learningRate = (float) 0.75;
	Neuron network[][];
	float weights[][][];

	public Net(){
		System.out.println("Please describe size of network! (Inputs, Hidden Layers, Hidden Layer Size, Outputs");
	}

	public Net(int inputs, int hidden, int depth, int outputs) {
		//initialize net size variables
		numIn = inputs;
		numHid = hidden;
		numDepth = depth;
		numOut = outputs;

		//initialize network array
		network = new Neuron[numHid + 2][];
		network[0] = new Neuron[numIn + 1];
		for (int i = 1; i <= numHid; i++) {
			network[i] = new Neuron[numDepth + 1];
		}
		network[numHid + 1] = new Output[numOut];
		
		//initialize weights array
		weights = new float[numHid + 1][][];
		for (int y = 0; y < (network.length - 1); y++) {
			weights[y] = new float[network[y].length][];
			for (int z = 0; z < network[y].length; z++) {
				weights[y][z] = new float[network[y + 1].length];
			}
		}
	}

	public void populate() {
		//Populating neuron objects
		for (int i = 0; i < numIn; i++) {
			network[0][i]  = new Input();
			//System.out.println("Input " + (i + 1) + " created.");
		}
		network[0][numIn] = new Bias();

		for (int j = 1; j <= numHid; j++) {
			//System.out.println("Hidden layer: " + j);

			for (int q = 0; q < numDepth; q++) {
				network[j][q] = new Neuron();
				//System.out.println("Neuron " + (q + 1) + " created.");
			}
			network[j][numDepth] = new Bias();
		}

		for (int r = 0; r < numOut; r++) {
			network[network.length - 1][r] = new Output();
			//System.out.println("Output " + (r + 1) + " created.");
		}
		
		//populating weights
		Random daRand = new Random();
		for (int a = 0; a < weights.length; a++){
			for (int b = 0; b < weights[a].length; b++){
				for (int c = 0; c < weights[a][b].length; c++){
					weights[a][b][c] = daRand.nextFloat();
				}
			}
		}
	}
	public void activate(){
		for (int d = 1; d < network.length; d++){
			for (int e = 0; e < network[d].length; e++) {
				network[d][e].process(weights[d - 1], network[d - 1], e);
			}
		}
	}
	public void train(float[] inputs, float[] expected) {
		if (inputs.length != numIn || expected.length != numOut) {
			System.out.println("Make sure inputs/outputs match network");
			return;
		} else {
			for (int l = 0; l < numIn; l++) {
				network[0][l].setInput(inputs[l]);
				//System.out.println("Input " + (l+1) + " : " + network[0][l].getOutput());
			}
			
			activate();
			
			for (int i = 1; i <= numOut; i++) {
				//System.out.println("Result " + i + ": " + network[numHid+1][i-1].getOutput());
				//System.out.println("Expected Result: " + expected[i-1]);
			}
			
			backProp(expected);
		}
	}

	public void backProp(float[] trainingData) {
		//init loss array
		float[][] loss = new float[network.length - 1][];
		for (int q = 1; q < network.length; q++) {
			loss[q-1] = new float[network[q].length];
		}
		// add initial training values to array
		if (trainingData.length == loss[loss.length-1].length)
		{
			for (int t = 0; t < trainingData.length; t++) {
				loss[loss.length-1][t] = network[numHid+1][t].getOutput() - trainingData[t];
				System.out.println("Loss " + (t+1) + ": " + loss[loss.length-1][t]);
			}
		} else {
			System.out.println("Training data and loss array sizes do not match! something is wrong...");
			return;
		}
	
		for (int d = loss.length - 2; d >= 0; d--){
			for (int n = loss[d].length - 1; n >= 0; n--) {
				float sumError = 0;
				for (int w = loss[d+1].length - 1; w >= 0; w--) {
					sumError += loss [d+1][w] * weights[d+1][n][w];
				}
				loss[d][n] = sumError;
				
				//System.out.println("Loss of neuron " + (d+1) + " " + n + " : " + loss[d][n]);
			}
		}

		//update weights
		for (int s = 0; s < weights.length; s++){
			for (int c = 0; c <  weights[s].length - 1; c++) {
				for (int p = 0; p < weights[s][c].length; p++) {
					//System.out.println(s+" "+c+" "+p+" before: " + weights[s][c][p]);
					weights[s][c][p] = weights[s][c][p] - (learningRate * network[s][c].getOutput() * loss[s][p]);
					//System.out.println(s + " " + c +" "+ p + " after: " + weights[s][c][p]);
				}
			}
		}
	}
}
