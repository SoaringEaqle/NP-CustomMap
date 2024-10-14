/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/*
 * This is like the FontDemo applet in volume 1, except that it
 * uses the Java 2D APIs to define and render the graphics and text.
 */
/*public class Drawhelp extends JFrame {



    static final int winW = 20, winH = 20;	//window width and height
    DrawingPanel panel;

    Drawhelp(){

        //set up JFrame
        this.setSize(winW, winH);
        this.setTitle("My first graphics program");
        this.setLocationRelativeTo(null); //always in middle
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new DrawingPanel();

        this.add(panel);

        this.setVisible(true); //the last thing you do
    }

    Rectangle2D.Double r = new Rectangle2D.Double ();

    private class DrawingPanel extends JPanel{
        //constructor
        DrawingPanel(){
            this.setBackground(new Color(255,255,222));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g); //will draw background color

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.setColor(Color.BLUE);
            g2.fillRect(r.x, r.y, r.width, r.height);

            g2.rotate(Math.toRadians(10));

            g.setColor(new Color(0,255,0,127));
            g2.fillRect(r.x, r.y, r.width, r.height);

        }
    }


}*/
