public class User {
    private String cardID;
    private int cardPWD;
    private String userName;
    private String call;
    private double account;
    public User(String cardID,int cardPWD,String userName,String call,double account){
        this.cardID = cardID;
        this.cardPWD = cardPWD;
        this.userName = userName;
        this.call = call;
        this.account = account;
    }
    public void changeAccount(double value){
        this.account = value;
    }

    public String getUserName() {
        return userName;
    }

    public double getAccount() {
        return account;
    }

    public String getCall() {
        return call;
    }
    public boolean biduiPwd(int inCardPwd){
        return inCardPwd==this.cardPWD;
    }
}
