package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Qlearning {
        private final double ALPHA = 0.1;
        private final double GAMMA = 0.9;
        //private final double EPS = 0.4;
        private final int MAX_EPOCH = 20000;
        private final int GRID_SIZE = 6;
        private final int ACTION_SIZE = 4;
        private int stateI;
        private int stateJ;
        private int[][] grid ;
        private double[][] qTable = new double[GRID_SIZE * GRID_SIZE][ACTION_SIZE];
        private int[][] actions ;
        List<String> ioptimalWayListe = new ArrayList<>();

    public Qlearning() {
            actions=new int[][]{
                    {0,-1}, //gauche
                    {0,1}, //droite
                    {1,0}, //bas
                    {-1,0} //hait
            };
            grid=new int[][]{
                    {0 , 0, -1, 0, 0, 0},
                    {0 ,-1, 0, 0, 0, 0},
                    {0 , 0, 0,-1, 0, 0},
                    {-1 , 0, -1, 0, 0, 0},
                    {0 ,-1, 0,-1, 0, 1},
                    {0 , 0, 0, 0, 0, -1}
            };


        }
        private void resetState(){
            stateI=0;
            stateJ=0;
        }

        private int choseAction(double eps){
            Random rn = new Random();
            double bestQ=0;
            int act=0;
            if(rn.nextDouble()<eps){
                act = rn.nextInt(ACTION_SIZE);
            } else{
                int st=stateI*GRID_SIZE+stateJ;
                for (int i = 0; i < ACTION_SIZE; i++) {
                    if(qTable[st][i]>bestQ){
                        bestQ=qTable[st][i];
                        act=i;
                    }
                }
            }
            return act;
        }

        private int executeAction(int act){
            stateI=Math.max(0,Math.min(actions[act][0]+stateI,GRID_SIZE-1));
            stateJ=Math.max(0,Math.min(actions[act][1]+stateJ,GRID_SIZE-1));
            return stateI*GRID_SIZE+stateJ;
        }

        private boolean finished(){
            return grid[stateI][stateJ]==1;
        }

        private void showResult(){
            resetState();
            int i=0;
            while (!finished()){
                int act = choseAction(0);
                String f="State: "+(stateI*GRID_SIZE+stateJ)+"-> action: "+act;
                ioptimalWayListe.add(f);
                i++;
                executeAction(act);
            }
            ioptimalWayListe.add("Final State: "+(stateI*GRID_SIZE+stateJ));
        }
    public List<String> getIoptimalWayListe() {
        return ioptimalWayListe;
    }

    public void runQlearning(){
            int it=0;
            int currentState;
            int nextState;
            int action,action1;

            while (it<MAX_EPOCH){
                resetState();
                while (!finished()){
                    currentState=stateI*GRID_SIZE+stateJ;
                    action = choseAction(0.4);
                    nextState = executeAction(action);
                    action1 = choseAction(0);
                    qTable[currentState][action]=qTable[currentState][action]+ALPHA*(grid[stateI][stateJ]+GAMMA*qTable[nextState][action1]-qTable[currentState][action]);
                }
                ++it;
            }
            showResult();
        }
    }

