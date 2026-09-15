/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template

********ไฟล์นี้เป็นไฟล์ที่ถูกแก้ไขหลังจากการอธิบายCodeหน้าชั้นเรียนครับ*******
----------                            นาย เศรษฐพงศ์ อภัยวงศ์ 6830250633                  ----------

*/
package cafe;
import java.util.Scanner;
/**
*
* @author Admin
*/
public class Cafe {
/**
 * @param args the command line arguments
 */
static String[] menu = {"Espresso\t","Americano\t","Latte\t","Cappuccino\t","Mocha\t","Tea\t","Green tea with milk","Fresh milk\t","Chocolate\t","Lychee juice\t"};
static double[] priceMenu ={60,65,75,75,65,40,50,45,50,40};
static double[] addAmount = new double[menu.length];
public void showMenu(){
        System.out.println("Here is our menu.");
        System.out.println("----------- Menu -----------");
        for(int i = 0; i < menu.length; i++){
            System.out.println( (i+1) + "\t" + menu[i] + "\t" +priceMenu[i]+"\t Baht.");
        }
        System.out.println("----------------------------");
}

public double calculator(double pricemenu,double amount){
        double fin = pricemenu*amount;
        return fin;
}

public void receipt(){
        System.out.println("========== RECEIPT ==========");
        double sumBefore = 0;
        for(int i=0;i<addAmount.length;i++){
        if(addAmount[i]==0) continue;
            System.out.println(menu[i]+"\t"+priceMenu[i]+"\t X"+addAmount[i]+"\t"+calculator(priceMenu[i],addAmount[i]));
            sumBefore += calculator(priceMenu[i],addAmount[i]);
        }
        double  net;
        net = sumBefore;
        double dis = 0;
        if( sumBefore >= 100 ){
            dis = net*0.10;
            net = net - dis;
        }
        System.out.println("-----------------------------");
        System.out.println("Total price(before discount) = "+ sumBefore);
        System.out.println("Discount = "+ dis);
        System.out.println("Net price = "+ net);
}
public void addMenu(int Quan,int choose){
        addAmount[choose] += Quan;
}
public int onlyNum() {
    while (!sc.hasNextInt()) {
            System.out.print("Please enter number only : ");
            sc.next();
    }
    return sc.nextInt();
} 
public int getChoose(){
   int chooseCheck;
    while(true){
            chooseCheck = onlyNum();
            chooseCheck--;
            if(chooseCheck == -1 ) break;
            if(chooseCheck >= 0 && chooseCheck < menu.length) break;
            System.out.print("Please enter number in menu range.(1-10)(0=close) : ");
        }  
        return chooseCheck;
}
public void amountCheck(int amount,int where){
    if(amount > 0){
        addMenu(amount, where);
        System.out.println("Added "+menu[where]+" x "+amount);
    } else {
        System.out.println("The quantity must be greater than 0. ");
    }
}
public void emptyOrNot(){
   for(int i=0;i<addAmount.length;i++){
        if (addAmount[i] != 0) {
            receipt();
            break;
        }
  }
}
public void goodBye(){
    System.out.println("=================================");
    System.out.println(" Thank you for using our service.");
    System.out.println("=================================");
}
static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
    // TODO code application logic here
        Cafe c = new Cafe();
        System.out.println("*****Welcome to cafe.*****");
        while(true){
            c.showMenu();
            System.out.print("Please choose menu by enter number.(1-10)(0=close): ");
            int choose = c.getChoose();
            if(choose == -1) break;
            System.out.print("How much. : ");
            int much = c.onlyNum();
            c.amountCheck(much,choose);
            System.out.print("Would you like to continue shopping? (y/n) : ");
            String con = sc.next();
            if(con.equalsIgnoreCase("n")) break;
        }
        c.emptyOrNot();
        c.goodBye();
    }
}