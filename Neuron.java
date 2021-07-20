public class Neuron {
	float output;
	
	public float getOutput() {
		return output;
	}
	
	public void setInput(float value){}	

	//do the calcs to update output!
	public void process(float[][] prevWts, Neuron[] prevNeurons, int target) {
		float sum = 0;
		for (int i = 0; i < prevNeurons.length; i++){
			sum += (prevNeurons[i].getOutput() * prevWts[i][target]);	
		}
		output = tanh(sum);
		
	}

	float sigmoid(float x) {
		return (float) (1.0 / (1.0 + Math.exp(-x)));	
	}

	float tanh(float x) {
		return (float) Math.tanh(x);
	}

	float reLU(float x) {
		if (x >= 0) {
			return x;
		} else {
			return 0;
		}
	}

	float step(float x) {
		if (x >= 0) {
			return 1;
		} else {
			return 0;
		}
	}
}

class Input extends Neuron {
	public void setInput(float value){
		this.output = value;
	}
}

class Output extends Neuron {
	public void process(float[][] prevWts, Neuron[] prevNeurons, int target) {
                float sum = 0;
                for (int i = 0; i < prevNeurons.length; i++){
                        sum += (prevNeurons[i].getOutput() * prevWts[i][target]);
                }
                output = reLU(sum);
	}
}

class Bias extends Neuron {
	public Bias(){
		output = 1;
	}

	public void process(float[][] thing, Neuron[] thing1, int thing3) {
		//System.out.println("Bias don't calculate!");
		return;
	}
}

