package be.uantwerpen.fti.ei;

import javax.swing.*;

//beeld = 1500 x 800
public class Map {
    public GraphicsContext grCtx;
    private int WindowWidth;
    private int WindowHeight;
    private int PinWidth;
    private int PinHeight;
    private double R = 1450 /(2*180);

    public Map(int Width, int Height) {
        this.WindowWidth = Width;
        this.WindowHeight= Height;
        this.grCtx = new GraphicsContext();
    }

    void render(){
        grCtx.render();
    }
    void setPin(double lengtegraad,double breedtegraad){
        grCtx.setPin(TransformX(lengtegraad),TransformY(breedtegraad));
        //grCtx.setPin(725,500);
    }
    int TransformX(double lengtegraad){
        int x_co = (int)(R*(180+lengtegraad));
        System.out.println("x:" +x_co);
        return x_co;
    }
    int TransformY(double breedtegraad){
        //int y_co = (int)(495.9 -3.69*breedtegraad + 0.004028*Math.pow(breedtegraad,2) - 0.0003496*Math.pow(breedtegraad,3)-0.000002021*Math.pow(breedtegraad,4));
        int y_co = (int) (493.8-3.756*breedtegraad+ 0.01907*Math.pow(breedtegraad,2) - 0.0003984*Math.pow(breedtegraad,3) - 0.000002621*Math.pow(breedtegraad,4) + 0.00000003007*Math.pow(breedtegraad,5));
        System.out.println("y:"+y_co);
        return y_co;
    }
}
