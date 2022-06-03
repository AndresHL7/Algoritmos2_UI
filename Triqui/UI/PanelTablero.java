package com.usc.ui;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


/**
 *
 * @author Romix
 */
public class PanelTablero extends JPanel implements ActionListener{
  
    Random aleatorio = new Random();
    JLabel etiquetaPrueba;
    final int X=1, O=0, VACIA = -1;
    int turno_actual = 1;
    boolean ganador = false;
    JButton botones[][];
    int tablero[][];
    

    public PanelTablero(){
    
       ganador = false;
        turno_actual = X;

        this.setLayout(new GridLayout(3,3));

        tablero = new int[3][3];
        botones = new JButton[3][3];

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                tablero[i][j] = VACIA;
                botones[i][j] = new JButton();
                botones[i][j].setActionCommand(""+i+j);
                botones[i][j].addActionListener(this);

                add(botones[i][j]);
            }
        }
    }

    /**
    * Maneja los eventos de los distintos elementos de UI
    */
    @Override
    public void actionPerformed(ActionEvent e) {

        String cualBoton = e.getActionCommand();

        if(turno_actual == X && ! ganador) {
            switch (cualBoton) {
                case "00":
                    //JOptionPane.showMessageDialog(this, "CLick en el botón 1");
                    botones[0][0].setText("X");
                    botones[0][0].setEnabled(false);
                    tablero[0][0] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
               case "01":
                    botones[0][1].setText("X");
                    botones[0][1].setEnabled(false);
                    tablero[0][1] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                case "02":
                    botones[0][2].setText("X");
                    botones[0][2].setEnabled(false);
                    tablero[0][2] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                case "10":
                    botones[1][0].setText("X");
                    botones[1][0].setEnabled(false);
                    tablero[1][0] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                case "11":
                    botones[1][1].setText("X");
                    botones[1][1].setEnabled(false);
                    tablero[1][1] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                    case "12":
                    botones[1][2].setText("X");
                    botones[1][2].setEnabled(false);
                    tablero[1][2] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                case "20":
                    botones[2][0].setText("X");
                    botones[2][0].setEnabled(false);
                    tablero[2][0] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                    case "21":
                    botones[2][1].setText("X");
                    botones[2][1].setEnabled(false);
                    tablero[2][1] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;
                    case "22":
                    botones[2][2].setText("X");
                    botones[2][2].setEnabled(false);
                    tablero[2][2] = 1;
                    validar();
                    JOptionPane.showMessageDialog(this, "Juega la máquina"   );
                    jugada_maquina();
                    break;

            }
        }

    }
    
     
    private void jugada_maquina() {
        
        boolean jugada = false;
        if(!ganador) {
            for (int i = 0; i < 3 && !jugada; i++) {
                for (int j = 0; j < 3 ; j++) {
                    if (tablero[i][j] == VACIA) {
                        tablero[i][j] = O;
                        botones[i][j].setText("O");
                        botones[i][j].setEnabled(false);
                        jugada = true;
                        break;
                        
                    }
                }
            }
        }
    }

    /*Valida si hay un ganador*/
    private void validar() {
        
        //validar primera fila:
        if(tablero[0][0]== tablero[0][1] && tablero[0][1] == tablero[0][2] && tablero[0][0] != VACIA){
            ganador = true;
            botones[0][0].setBackground(Color.BLUE);
            botones[0][1].setBackground(Color.BLUE);
            botones[0][2].setBackground(Color.BLUE);
        
        }

        //validar segunda fila:
         if(tablero[1][0]== tablero[1][1] && tablero[1][1] == tablero[1][2] && tablero[1][0] != VACIA){
            ganador = true;
            botones[1][0].setBackground(Color.BLUE);
            botones[1][1].setBackground(Color.BLUE);
            botones[1][2].setBackground(Color.BLUE);
         
         }

        //validar tercera fila:
         if(tablero[2][0]== tablero[2][1] && tablero[2][1] == tablero[2][2] && tablero[2][0] != VACIA){
            ganador = true;
            botones[2][0].setBackground(Color.BLUE);
            botones[2][1].setBackground(Color.BLUE);
            botones[2][2].setBackground(Color.BLUE);
         
         }

        //validar columna 1
        
         if(tablero[0][0]== tablero[1][0] && tablero[1][0] == tablero[2][0] && tablero[0][0] != VACIA){
            ganador = true;
            botones[0][0].setBackground(Color.BLUE);
            botones[1][0].setBackground(Color.BLUE);
            botones[2][0].setBackground(Color.BLUE);
         
         }
         
        //Validar columna 2 
         if(tablero[0][1]== tablero[1][1] && tablero[1][1] == tablero[2][1] && tablero[0][1] != VACIA){
            ganador = true;
            botones[0][1].setBackground(Color.BLUE);
            botones[1][1].setBackground(Color.BLUE);
            botones[2][1].setBackground(Color.BLUE);
         
         }
        //Validar columna 3 
         if(tablero[0][2]== tablero[1][2] && tablero[1][2] == tablero[2][2] && tablero[0][2] != VACIA){
            ganador = true;
            botones[0][2].setBackground(Color.BLUE);
            botones[1][2].setBackground(Color.BLUE);
            botones[2][2].setBackground(Color.BLUE);
         
         }

        //validar diagonales:
        
        //Validar diagonal 1
         if(tablero[0][0]== tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != VACIA){
            ganador = true;
            botones[0][0].setBackground(Color.BLUE);
            botones[1][1].setBackground(Color.BLUE);
            botones[2][2].setBackground(Color.BLUE);
         
         }
         //Validar diagonal 2
         if(tablero[0][2]== tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != VACIA){
            ganador = true;
            botones[0][2].setBackground(Color.BLUE);
            botones[1][1].setBackground(Color.BLUE);
            botones[2][0].setBackground(Color.BLUE);
         
         }
         
         
    

    
        
       
        
    
    }
}

