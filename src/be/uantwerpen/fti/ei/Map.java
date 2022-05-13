package be.uantwerpen.fti.ei;

import java.awt.*;

public class Map {
    public GraphicsContext grCtx;
    private final double scaleFactorX = (double) (Toolkit.getDefaultToolkit().getScreenSize().width)/1550;
    private final double scaleFactorY = (double) (Toolkit.getDefaultToolkit().getScreenSize().height)/900;

    public Map() {
        this.grCtx = new GraphicsContext();
    }

    void update(){
        grCtx.update();
    }
    void render(){
        grCtx.render();
    }

    void setPin(double lengtegraad,double breedtegraad){
        grCtx.setPin((int) (TransformX(lengtegraad)*scaleFactorX),(int) (TransformY(breedtegraad)*scaleFactorY));
    }
    int TransformX(double lengtegraad){
        return (int) Math.round(725 + 3.733*lengtegraad - 0.0003181*Math.pow(lengtegraad,2) + 0.000008314*Math.pow(lengtegraad,3) + 0.00000004178*Math.pow(lengtegraad,4)-0.000000001205*Math.pow(lengtegraad,5));
    }
    int TransformY(double breedtegraad){
        return (int) Math.round(493.8-3.756*breedtegraad+ 0.01907*Math.pow(breedtegraad,2) - 0.0003984*Math.pow(breedtegraad,3) - 0.000002621*Math.pow(breedtegraad,4) + 0.00000003007*Math.pow(breedtegraad,5));
    }
}

