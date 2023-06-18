package calculation;

import javax.swing.JFrame;

public class MainCalc {
    
    public static void main(String[] args){
        // Фрейм Калькулятора
        Frame MainCalc = new Frame();
        MainCalc.setTitle("Калькулятор");
         //Установка размеров калькулятора
        MainCalc.setBounds(200,180,380,610);
        // Закрытие окна калькулятора
        MainCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainCalc.setVisible(true);
    }
    
}
