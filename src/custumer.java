
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class custumer {
    ResultSet rs= null;
    
    String[] foodss={"Chicken Burger","Rolls","Pan cake","Mango","Milo","Apple","Lemon","Orange"};
    public double total_tax;
    public double total_amount;
    private double drink_cost;
    private double meal_cost;
    
    private static int total_count_Chicken_Burger;
    private static int total_count_Rolls;
    private static int total_count_Pan_cake;
    private static int total_count_Mango;
    private static int total_count_Milo;
    private static int total_count_Lemon;
    private static int total_count_Orange;
    private static int total_count_Apple;
    int[] countArray={total_count_Chicken_Burger,total_count_Rolls,total_count_Pan_cake,total_count_Mango,total_count_Milo,total_count_Apple,total_count_Lemon,total_count_Orange};
    
    private static int taxCh;
    private static int taxRo;
    private static int taxPa;
    private static int taxMa;
    private static int taxMi;
    private static int taxLe;
    private static int taxOr;
    private static int taxAp;
    double[] taxArray={taxCh,taxRo,taxPa,taxMa,taxMi,taxAp,taxLe,taxOr};
    
    private static int priCh;
    private static int priRo;
    private static int priPa;
    private static int priMa;
    private static int priMi;
    private static int priLe;
    private static int priOr;
    private static int priAp;
    double[] priArray={priCh,priRo,priPa,priMa,priMi,priAp,priLe,priOr};
    
    int len = countArray.length;
    static int check;

    custumer(ResultSet rs){
        try {
            for(int i=1;i<=len;i++){
                rs.absolute(i);
                countArray[i-1]=rs.getInt("count");
                taxArray[i-1]=rs.getDouble("tax");
                priArray[i-1]=rs.getDouble("price");
                
              
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(custumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void setValue(String food,String value){
        int val;            // input value
        //setting value to val variable
        if(value.equalsIgnoreCase("")){
            val = 0;
        }
        else{
            val= Integer.valueOf(value);
        }
        
        if(food.equalsIgnoreCase("Chicken Burger")){
            
            if(countArray[0]>=val){
                total_amount=total_amount+val*priArray[0];
                total_tax=total_amount+val*taxArray[0];
                countArray[0]=countArray[0]-val;
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Rolls")){
            if(countArray[1]>=val){
                total_amount=total_amount+val*priArray[1];
                total_tax=total_amount+val*taxArray[1];
                countArray[1]=countArray[1]-val;
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Pan cake")){
            if(countArray[2]>=val){
                total_amount=total_amount+val*priArray[2];
                total_tax=total_amount+val*taxArray[2];
                countArray[2]=countArray[2]-val;
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Mango")){
            if(countArray[3]>=val){
                total_amount=total_amount+val*priArray[3];
                total_tax=total_amount+val*taxArray[3];
                countArray[3]=countArray[3]-val;
                drink_cost=priArray[3];
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Milo")){
            if(countArray[4]>=val){
                total_amount=total_amount+val*priArray[4];
                total_tax=total_amount+val*taxArray[4];
                countArray[3]=countArray[4]-val;
                drink_cost=priArray[4];
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Apple")){
            if(countArray[5]>=val){
                total_amount=total_amount+val*priArray[5];
                total_tax=total_amount+val*taxArray[5];
                countArray[5]=countArray[5]-val;
                drink_cost=priArray[5];
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Lemon")){
            if(countArray[6]>=val){
                total_amount=total_amount+val*priArray[6];
                total_tax=total_amount+val*taxArray[6];
                countArray[6]=countArray[6]-val;
                drink_cost=priArray[6];
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Orange")){
            if(countArray[7]>=val){
                total_amount=total_amount+val*priArray[7];
                total_tax=total_amount+val*taxArray[7];
                countArray[7]=countArray[7]-val;
                drink_cost=priArray[7];
            }
            else{
                check=1;
            }
        }
        else if(food.equalsIgnoreCase("Select a drink")){
                total_amount=total_amount;
                total_tax=total_amount;
                drink_cost=0;
        }
        
    }
    public void checkUpdate(){
        if(check==0){
            for(int i =1;i<=len;i++){
                try {
                    DBConnection.update(foodss[i-1], countArray[i-1]);
                } catch (SQLException ex) {
                    Logger.getLogger(custumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
            total_amount=0;
            total_tax=0;
        }
    }
    public double getTax(){
        return total_tax;
    }
    public double getTotal(){
        return total_amount;
    }
    public int getCheck(){
        return check;
    }
    public double getDrinkCost(){
        return drink_cost;
    }
    public double getmealCost(){
        meal_cost=total_amount-drink_cost;
        return meal_cost;
    }
    
    
}
