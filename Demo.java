public class Demo {
	public static void main(String[] args){
		Net daNet = new Net(2, 2, 4, 1);    //for test
                //Net daNet = new Net (2,2,4,2);
		daNet.populate();

                float[] in = {1,0};
                float[] out = {1};
		float[] in1 = {0,1};
                float[] out1 = {1};
		float[] in2 = {1,1};
                float[] out2 = {0};
		float[] in3 = {0,0};
                float[] out3 = {0};

		for (int i = 0; i < 100; i++){
		daNet.train(in, out);
		daNet.train(in1, out1);
		daNet.train(in2, out2);
		daNet.train(in3, out3);
		}
	}
}
