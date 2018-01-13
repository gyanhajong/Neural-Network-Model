package ann;

import java.io.IOException;


public class ANN {

	int getTarget(int[] inputs) {
		if(inputs[0]==1&&inputs[1]==1)
			return 1;
		else
			return 0;
	}

    public static void main(String[] args) throws IOException {
       NetworkBuilder NN = new NetworkBuilder({2,1});
       int[][] inputs = new int[3][2];
       inputs[0] = {0, 0};
       inputs[1] = {0, 1};
       inputs[1] = {1, 1};

       for(int[] inputs: inputs) {

       		learning(inputs, getTarget(inputs));
       }
    }
    
}
