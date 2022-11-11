import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import javax.swing.event.*;

public class tic_tac implements ActionListener{
    
    private Random rand;
    private JFrame frame;
    private JButton []buttons;
    private JPanel text_panel,button_panel;
    private JTextField text;
    private boolean player_status,rematch=false;
    private int no_of_turns=0;

    //initialization
    public tic_tac(){ 
        rand=new Random();
        frame=new JFrame();
        buttons=new JButton[9];
        text_panel=new JPanel();
        button_panel=new JPanel();
        text=new JTextField();
        player_status=false;
    }

    //setting up Graphics
    public void GUI(){
        //setting up frame
        frame.setTitle("Tic tac toe");
        ImageIcon img=new ImageIcon("tic_image.jpg");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());

        //setting up text field
        text.setFont(new Font("Comic sans ms",Font.BOLD,75));
        text.setForeground(new Color(25,250,0));
        text.setBackground(new Color(25,25,25));
        text.setText("TIC-TAC-TOE");
        text.setEditable(false);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);

        //seting up text panel
        text_panel.setLayout(new BorderLayout());
        text_panel.setBounds(0,0,800,100);
        text_panel.add(text,JLabel.CENTER);

        //setting up buttons
        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Comic sans ms",Font.BOLD,50));
            buttons[i].setOpaque(true);
            buttons[i].setBackground(new Color(255,255,255));
            button_panel.add(buttons[i]);
        }

        //setting button panel
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        //adding panels
        frame.add(text_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setVisible(true);
    }

    //funtion for 1st turn
    public void Whosturn(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //random allocation of turns
        if(rand.nextInt(2)==0){
            player_status=true;
            text.setText("X's Turn");
        }
        else{
            player_status=false;
            text.setText("O's turn");
        }
    }

    //function for winning checks
    public void check(){
        //conditions for x winnings
        if(buttons[0].getText().equalsIgnoreCase("x") && buttons[1].getText().equalsIgnoreCase("x") && buttons[2].getText().equalsIgnoreCase("x")){
            Xwins(0,1,2);
        }
        if(buttons[0].getText().equalsIgnoreCase("x") && buttons[3].getText().equalsIgnoreCase("x") && buttons[6].getText().equalsIgnoreCase("x")){
            Xwins(0,3,6);
        }
        if(buttons[0].getText().equalsIgnoreCase("x") && buttons[4].getText().equalsIgnoreCase("x") && buttons[8].getText().equalsIgnoreCase("x")){
            Xwins(0,4,8);
        }
        if(buttons[1].getText().equalsIgnoreCase("x") && buttons[4].getText().equalsIgnoreCase("x") && buttons[7].getText().equalsIgnoreCase("x")){
            Xwins(1,4,7);
        }
        if(buttons[2].getText().equalsIgnoreCase("x") && buttons[5].getText().equalsIgnoreCase("x") && buttons[8].getText().equalsIgnoreCase("x")){
            Xwins(2,5,8);
        }
        if(buttons[2].getText().equalsIgnoreCase("x") && buttons[4].getText().equalsIgnoreCase("x") && buttons[6].getText().equalsIgnoreCase("x")){
            Xwins(2,4,6);
        }
        if(buttons[6].getText().equalsIgnoreCase("x") && buttons[7].getText().equalsIgnoreCase("x") && buttons[8].getText().equalsIgnoreCase("x")){
            Xwins(6,7,8);
        }
        //conditions for o winning
        if(buttons[0].getText().equalsIgnoreCase("o") && buttons[1].getText().equalsIgnoreCase("o") && buttons[2].getText().equalsIgnoreCase("o")){
            Owins(0,1,2);
        }
        if(buttons[0].getText().equalsIgnoreCase("o") && buttons[3].getText().equalsIgnoreCase("o") && buttons[6].getText().equalsIgnoreCase("o")){
            Owins(0,3,6);
        }
        if(buttons[0].getText().equalsIgnoreCase("o") && buttons[4].getText().equalsIgnoreCase("o") && buttons[8].getText().equalsIgnoreCase("o")){
            Owins(0,4,8);
        }
        if(buttons[1].getText().equalsIgnoreCase("o") && buttons[4].getText().equalsIgnoreCase("o") && buttons[7].getText().equalsIgnoreCase("o")){
            Owins(1,4,7);
        }
        if(buttons[2].getText().equalsIgnoreCase("o") && buttons[5].getText().equalsIgnoreCase("o") && buttons[8].getText().equalsIgnoreCase("o")){
            Owins(2,5,8);
        }
        if(buttons[2].getText().equalsIgnoreCase("o") && buttons[4].getText().equalsIgnoreCase("o") && buttons[6].getText().equalsIgnoreCase("o")){
            Owins(2,4,6);
        }
        if(buttons[6].getText().equalsIgnoreCase("o") && buttons[7].getText().equalsIgnoreCase("o") && buttons[8].getText().equalsIgnoreCase("o")){
            Owins(6,7,8);
        }

    }
    private void Xwins(int a, int b, int c){
        buttons[a].setBackground(new Color(0,255,0));
        buttons[b].setBackground(new Color(0,255,0));
        buttons[c].setBackground(new Color(0,255,0));
        text.setText("X WINS");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        restart();
    }
    private void Owins(int a, int b, int c){
        buttons[a].setBackground(new Color(0,255,0));
        buttons[b].setBackground(new Color(0,255,0));
        buttons[c].setBackground(new Color(0,255,0));
        text.setText("O WINS");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        restart();
    }
    private void draw(){
        if(no_of_turns==9){
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            text.setText("DRAW");
            restart();
        }
        else{
            //do nothing
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(!rematch){
            for(int i=0;i<9;i++){
                if(player_status){
                        if(e.getSource()==buttons[i]){
                            no_of_turns+=1;
                            buttons[i].setForeground(new Color(0,0,250));
                            buttons[i].setText("X");
                            player_status=false;
                            //buttons[i].setEnabled(false);
                            text.setText("O's turn");
                            check();
                        }
                }
                    else{
                        if(e.getSource()==buttons[i]){
                            no_of_turns+=1;
                            buttons[i].setText("O");
                            buttons[i].setForeground(new Color(250,0,0));
                            player_status=true;
                            //buttons[i].setEnabled(false);
                            text.setText("X's turn");
                            check();
                    }
                }
            }
        }
        else{
            if(e.getSource()==buttons[3]){
                enabler(true);
                Whosturn();
                rematch=false;
            }
            if(e.getSource()==buttons[5]){
                frame.dispose();
            }
        }
        draw();
    }
    public void restart(){
        frame.dispose();
        JFrame choice=new JFrame("Tic Tac Toe");
        choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choice.setBounds(0,0,200,200);
        choice.setResizable(false);
        choice.setVisible(true);
    }
    public void enabler(boolean what){
            for(int i=0;i<9;i++){
                buttons[i].setText("");
                buttons[i].setBackground(new Color(255,255,255));
                buttons[i].setEnabled(what);
            }

    }
   public static void main(String args[]){
        tic_tac obj=new tic_tac();
        obj.GUI();
        obj.Whosturn();
   }
}