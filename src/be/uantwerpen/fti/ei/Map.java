package be.uantwerpen.fti.ei;

import java.awt.*;

public class Map {
    public GraphicsContext grCtx;
    private int WindowWidth;
    private int WindowHeight;
    private int PinWidth;
    private int PinHeight;
    private double R = 1450 /(2*180);
    private final double scaleFactorX = (double) (Toolkit.getDefaultToolkit().getScreenSize().width)/1920;
    private final double scaleFactorY = (double) (Toolkit.getDefaultToolkit().getScreenSize().height)/1080;

    public Map(int Width, int Height) {
        this.WindowWidth = Width;
        this.WindowHeight= Height;
        this.grCtx = new GraphicsContext();
    }

    void render(){
        grCtx.render();
    }
    void setPin(double lengtegraad,double breedtegraad){
        grCtx.setPin((int) (TransformX(lengtegraad)*scaleFactorX),(int) (TransformY(breedtegraad)*scaleFactorY));
        //grCtx.setPin(725,500);
    }
    int TransformX(double lengtegraad){
        int x_co = (int) Math.round(725 + 3.733*lengtegraad - 0.0003181*Math.pow(lengtegraad,2) + 0.000008314*Math.pow(lengtegraad,3) + 0.00000004178*Math.pow(lengtegraad,4)-0.000000001205*Math.pow(lengtegraad,5));
        System.out.println("x:" +x_co);
        return x_co;
    }
    int TransformY(double breedtegraad){
        //int y_co = (int)(495.9 -3.69*breedtegraad + 0.004028*Math.pow(breedtegraad,2) - 0.0003496*Math.pow(breedtegraad,3)-0.000002021*Math.pow(breedtegraad,4));
        int y_co = (int) Math.round(493.8-3.756*breedtegraad+ 0.01907*Math.pow(breedtegraad,2) - 0.0003984*Math.pow(breedtegraad,3) - 0.000002621*Math.pow(breedtegraad,4) + 0.00000003007*Math.pow(breedtegraad,5));
        System.out.println("y:"+y_co);
        return y_co;
    }
}

