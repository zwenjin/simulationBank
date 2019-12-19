import java.util.Scanner;

public class Bank {
    public DBUtil BankDB;
    private User useingUser;

    public Bank() {
        System.out.println("欢迎进入网上银行系统!");
        while (true) {
            System.out.println("输入银行卡号:");
            Scanner sc = new Scanner(System.in);
            String cardID = sc.nextLine();
            System.out.println("输入银行卡密码");
            int cardPWD = sc.nextInt();
            if (this.logIn(cardID, cardPWD)) {
                System.out.println("登陆成功!尊敬的" + useingUser.getUserName());
                break;
            } else {
                System.out.println("登陆失败");
            }
        }
        while (true) {
            System.out.println("请输入您要进行的操作类型，按回车结束\n存款:1\t余额:2\t取款:3\t退出:4:");

            Scanner sc1 = new Scanner(System.in);
            int a = sc1.nextInt();
            if (a == 1) {
                System.out.println("输入存款金额:");
                if (deposit(sc1.nextDouble())) {
                    System.out.println("存款成功");
                } else {
                    System.out.println("失败");

                }
            } else if (a == 2) {
                System.out.println("您的余额为:" + this.getbalance());
            } else if (a == 4) {
                System.exit(0);
            } else if (a == 3) {
                if (this.withdrawal(sc1.nextDouble())) {
                    System.out.println("取款成功");
                } else {
                    System.out.println("失败");
                }
            }
        }
    }

    public boolean logIn(String cardID, int cardPWD) {
        this.useingUser = BankDB.getUser(cardID);
        return useingUser.biduiPwd(cardPWD);
    }

    public boolean deposit(double money) {
        if (money > 0) {
            useingUser.changeAccount(useingUser.getAccount() + money);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdrawal(double money) {
        if (money > useingUser.getAccount()) {
            return false;
        } else {
            useingUser.changeAccount(useingUser.getAccount() - money);
            return true;
        }
    }

    public double getbalance() {
        return useingUser.getAccount();
    }
}
