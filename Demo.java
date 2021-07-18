public class Demo {
	public static void main(String[] args){
		Net daNet = new Net(2, 1, 4, 1);    //for test
                //Net daNet = new Net (2,2,4,2);
		daNet.populate();

                float[] in = {1,0};
                float[] out = {1};
		daNet.train(in, out);
	}
}
