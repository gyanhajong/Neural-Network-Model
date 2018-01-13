package ann;

import java.io.IOException;
import java.util.Scanner;

public class ANN {
    
    static int getlabel(float[] inputs) {
        if(inputs[0]==1&&inputs[1]==1)
           return 1;
        else
           return 0;
    }

    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in);
        int[] top = {2,1};                       //2 INPUTS AND 1 OUTPUT
        NetworkBuilder N = new NetworkBuilder(top);
        float[][] inputs = new float[3][2];
        inputs[0][0] = 0; inputs[0][1] = 0;
        inputs[1][0] = 1; inputs[1][1] = 0;
        inputs[2][0] = 1; inputs[2][1] = 1;

        //Training the Network
        for(float[] input: inputs) {

             N.learning(input,getlabel(input));
        }
        
       System.out.println("Training Completed...");

       //Testing 
       for(int i = 0; i < 5; ++i) {
           float[] n = new float[2];
           n[0] = s.nextFloat();
           n[1] = s.nextFloat();
           float[] output = N.forwardPropagation(n);
           for(float o: output) {
               System.out.print((int)o + " ");
           }
           System.out.println();
       }
    }
}
