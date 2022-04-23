package be.uantwerpen.fti.ei;

import java.awt.*;

public class Pin {
    private double coordinateNorth;
    private double coordinateEast;
    private GraphicsContext grCtx;

    public Pin(double coordinateEast, double coordinateNorth, GraphicsContext grCtx) {
        this.coordinateNorth = coordinateNorth;
        this.coordinateEast = coordinateEast;
        this.grCtx = grCtx;
    }

    int TransformY(double breedtegraad){
        //int y_co = (int)(495.9 -3.69*breedtegraad + 0.004028*Math.pow(breedtegraad,2) - 0.0003496*Math.pow(breedtegraad,3)-0.000002021*Math.pow(breedtegraad,4));
        int y_co = (int) (493.8-3.756*breedtegraad+ 0.01907*Math.pow(breedtegraad,2) - 0.0003984*Math.pow(breedtegraad,3) - 0.000002621*Math.pow(breedtegraad,4) + 0.00000003007*Math.pow(breedtegraad,5));
        System.out.println("y:"+y_co);
        return y_co;
    }

    int TransformX(double lengtegraad){
        double r = 1450 / (2 * 180);
        int x_co = (int)(r *(180+lengtegraad));
        System.out.println("x:" +x_co);
        return x_co;
    }

    public void draw(){
        Graphics2D g2d = this.grCtx.getG2d();
        g2d.drawImage(grCtx.pinImg, TransformX(coordinateEast), TransformY(coordinateNorth), null);
    }
}
