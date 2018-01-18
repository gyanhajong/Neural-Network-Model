package ann;

public class Neuron {
    
    float[] weights;
    float theta;
    float[] input;  //Store the input that is received
    Neuron(int N) {
        weights = new float[N];
        theta = (float) Math.random();
        for(int i = 0; i < weights.length; ++i) {
            weights[i] = (float) Math.random();
        }
    }
   
    //Summation 
    float summation() {
        
        float sum = 0.0f;
        for(int i = 0; i < weights.length; ++i)
        {
            sum = sum + weights[i]*input[i];
        }
       return sum-theta;
    }
    
    //Activation Function
    float activation(float val) {
        return val;
    }
    
    float getOutput(float[] inp) {
        input = inp.clone();
        return activation(summation(input));
    }

    //Weight Update
    void weightUpdate(float error, float eta) {
        theta = theta - error*eta;
        for(int i = 0; i < weights.length; ++i) {
            weights[i] = weights[i] + (error*eta*input[i]);
        }
    }
}
