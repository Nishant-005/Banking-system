// creating a banking website for user to access there account at home 
import java.util.*;
public class Banking {
    //for transfering csh to other account
    static void transfer(int user[],int password[],int length,int balance[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter receiver user id");
        System.out.println("Enter your user id");
        System.out.println("Enter your password");
        System.out.println("Enter the amount you want to send");
        int sender_bal=sc.nextInt();
        int receiver=sc.nextInt();
        int sender_id=sc.nextInt();
        int sender_pswrd=sc.nextInt();
        for(int i=0;i<length;i++){
            if(user[i]==sender_id && password[i]==sender_pswrd){
                for(int j=0;j<length;j++){
                    if(user[j]==receiver && sender_bal<balance[i]){
                        balance[j]=balance[j]+sender_bal;
                    }
                }
            }
        }

    }
    //for changing of password
    static void pswrd_changer(int id,int user[],int password[],int paswrd,int desired,int length){
        for(int i=0;i<length;i++){
            if(id==user[i] && paswrd==password[i]){
                password[i]=desired;
            }
        } 
    }
    //for genrating random values
    static void random_values(int no,int user[],int balance[],int password[]){
        Random rand=new Random();
        for(int i=0;i<=no;i++){
            user[i]=rand.nextInt(10005,99905);
            password[i]=rand.nextInt(1111,9999);
            balance[i]=rand.nextInt(100,556000);
        }
    }
    //creating a random and unique id genator for user
    static int id_genrator(int user[]){
        int genator=1111;
        Random rand=new Random();
        genator=rand.nextInt(99990);
        for(int i=0;i<user.length;i++){
            if(user[i]!=genator){
                continue;
            }
            else{
                id_genrator(user);
            }
        }
        return genator;
    }
    //creaing balance checker functions
    static int Balance_checker(int id,int len_user,int[] user,int[] balance,int[] password,int paswrd,int length){
        int val=0;
        if(length==0){
            val=00;
        }
    for(int i=0;i<len_user;i++){
        if(id==user[i] && paswrd==password[i]){
            val=balance[i];
           break;
        }
    }
    return val;
    }

    //creating function for withdraw of cash
    static int withdraw_doner (int id,int user[],int balance[],int password[],int paswrd,int length){
        int val=000;
        if(length==0){
            val=00;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount for withdraw");
        int widh=sc.nextInt(); // for enterning amount for withdraw
        for(int i=0;i<user.length;i++){
            if(id==user[i] && paswrd==password[i]){
                val=balance[i]-widh;
            }
            else{
                val=0;
            }
        }
        return val;
    }
    //main method__________________!!
    public static void main(String[] args){
        int length=1000;
        int password[]=new int[9999];
        int user[]=new int[9999];
        int balance[]=new int[9999];
        int paswrd;
        int unique=10005; //for unique id
        //creating fake values for program
        random_values(length, user, balance, password);
        // creating main function
        System.out.println("Welcome to our banking website");
        int repeat=55;
        System.out.println("Please choose  the right operation \n 1.For existing user \n 2.For new user");
        Scanner sc=new Scanner(System.in);
        //Asking value of intial input to access old or new account
        int intial=sc.nextInt();
        // giving more option for easy for user
        switch (intial) {
            case 1:
            System.out.println("Choose correct option to access your account \n 1.For checking balance \n 2.Send money to other account\n 3.For withdraw cash\n4.Change password for account"); 
            int choice_existing=sc.nextInt();
            System.out.println("Please enter your Unique id");
            int id=sc.nextInt();
            System.out.println("Please enter your password");
            paswrd=sc.nextInt();
             //For existing user showing the result;
          
        switch ( choice_existing) {
            case 1:
                int value= Balance_checker(id,user.length,user,balance,password,paswrd,length);
                if(value!=00){
                    System.out.print("Your  balance is  " +value);
                }
                else{
                    System.out.println("No such user found");
                }
            break;
            case 2:
            transfer(user, password, length, balance);
            break;

            case 3:
            int balan=withdraw_doner(id, user, balance, password, paswrd,length);
            if(balan!=0){
                System.out.println("Now your current balance is"+balan);
            }
            else if(balan==00 || balan==0){
                System.out.println("No such user is found!!");
            }
            break;
            case 4:
            System.out.println("Enter the new password to change");
            int desired=sc.nextInt();
            pswrd_changer(id, user, password, paswrd, desired, length);
            break;
            default:
            System.out.println("Enter the Right choice please!!");
            break;
        }
        break;
            case 2:
            System.out.println("First of all welcome to our bank ");
            System.out.println("plese deposit some amount in the account");
            int newb=sc.nextInt();
            int newuser=length;
            balance[newuser]=newb;
            System.out.println("plese set your password");
            int pss=sc.nextInt();  //local variable for new user password setup
            password[newuser]=pss;
            user[newuser]=id_genrator(user);
            System.out.println("your unique id is  "+user[newuser]+"   "+ "your set password is "+password[newuser]);
            length++;
            break;
            default:
            System.out.println("Enter the right choice!!");
                break;
        }
        System.out.println("Want to access more option but you should be authorised person");
        System.out.println("Type 1 for yes and 2 for no");
        int authorise=sc.nextInt();
        if(authorise==1){
            System.out.println("please enter unique id and password to access");
            int A=sc.nextInt();
            int B=sc.nextInt();
            int TrueA=1234;
            int TrueB=4321;
            if(A==TrueA && B==TrueB){
                for(int i=0;i<length;i++){
                    System.out.print("user="+user[i]);
                    System.out.print("  ");
                    System.out.print("Balance="+balance[i]);
                    System.out.print("  ");
                    System.out.print("password="+password[i]);
                    System.out.print("  ");
                    System.out.println();
                }
            }
        }
        System.out.println("Thankyou for using our bank service");
    }
}
