package ann;

import java.util.ArrayList;

public class NetworkBuilder {

    int n_Layers;                   //Number of layers
    int[] topology;                 //Network topology represented as array
    float eta = 0.1f;               //Learning Rate
    ArrayList<Neuron>[] NN;

    NetworkBuilder(int[] top) {
        /* Eg: top = {1,2,2,1} implies -> 
                    input layer with 1 neuron,
                    2 hidden layer with 2 neurons each
                    and output layer with one output
         */
        topology = top;
        n_Layers = topology.length;

        //Creating n_Layers-1 of layers (excluding input layer)
        NN = new ArrayList[n_Layers - 1];

        //Creating each layer neurons
        for (int i = 0; i < n_Layers - 1; ++i) {

            ArrayList<Neuron> L = new ArrayList<>();

            for (int j = 0; j < topology[i + 1]; ++j) {

                L.add(new Neuron(topology[i]));
            }
            NN[i] = L;
        }
    }

    //Forward Propagation
    float[] forwardPropagation(float[] input) {
        float[] A = input;

        for (int i = 0; i < n_Layers - 1; ++i) {

            float[] output = new float[topology[i + 1]];

            for (int neuron_i = 0; neuron_i < topology[i + 1]; ++neuron_i) {
                output[neuron_i] = NN[i].get(neuron_i).getOutput(A);
            }
            A = output;
        }

        return A;
    }

    //Training the network
    void learning(float[] input, float target) {

        float[] output;

        int k = 0;
        while(true) {
            output = forwardPropagation(input);
            boolean f = false;
            
            for (int i = 0; i < output.length; ++i) {
                float error = target - output[i];
                
                if(Math.abs(error)>=0&&Math.abs(error)<=0.1)
                {
                    f = true;
                    break;
                }
                for (int layer_i = 0; layer_i < n_Layers - 1; ++layer_i) {
                    for (int neuron_i = 0; neuron_i < topology[layer_i + 1]; ++neuron_i) {
                        NN[layer_i].get(neuron_i).weightUpdate(error, eta);
                    }
                }
              
            }
            if(f)
                break;
        }

    }
}
