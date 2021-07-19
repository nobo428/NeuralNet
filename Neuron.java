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
		output = (float) (1.0 / (1.0 + Math.exp(-sum))); //sigmoid
		
	}

	float sigmoid(float x) {
		return (float) (1.0 / (1.0 + Math.exp(-x)));	
	}

	float tanh(float x) {
		return (float) Math.tanh(x);
	}
}

class Input extends Neuron {
	public void process() {
		System.out.println("I'm an input! I can't process anything");
	}

	public void setInput(float value){
		this.output = value;
	}
}

class Output extends Neuron {
	public void process() {
		System.out.println("I'm an output!");
	}
}

class Bias extends Neuron {
	public Bias(){
		output = 1;
	}

	public void process(float[][] thing, Neuron[] thing1, int thing3) {
		return;
	}
}
