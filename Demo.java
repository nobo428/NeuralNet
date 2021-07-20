import java.util.Scanner;

public class Demo {
	public static void main(String[] args){
		final int OUTPUTS = 1;
		final int DEPTH = 4;
		final int HIDDEN = 2;
		final int INPUTS = 2;	

                float[] in = {1,0};
                float[] out = {1};
		float[] in1 = {0,1};
                float[] out1 = {1};
		float[] in2 = {1,1};
                float[] out2 = {0};
		float[] in3 = {0,0};
                float[] out3 = {0};


		float[] last4Error = new float[4];
		float sumL4E;
		float L4AvgE;
		Net daNet = new Net(INPUTS, HIDDEN, DEPTH, OUTPUTS);	

		do{	
			daNet.populate();
			
			sumL4E = 0;
			for (int i = 0; i < 1000; i++){
				last4Error[0] = daNet.train(in, out);
				last4Error[1] = daNet.train(in1, out1);
				last4Error[2] = daNet.train(in2, out2);
				last4Error[3] = daNet.train(in3, out3);
			}

			for (float value : last4Error){
				sumL4E += value;
			}
			
			L4AvgE = sumL4E / 4;

			System.out.println(L4AvgE);

		} while (L4AvgE > 0.05);

		daNet.test(in3);
		daNet.test(in1);
		daNet.test(in2);
		daNet.test(in);
	}
}
