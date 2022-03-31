package net.src;

public class VerifyUserAccount {
    
    private int id;
    private String account;
    private String code;
    private String date;
    
    public VerifyUserAccount(int id,String account,String code,String date){
        this.id=id;
        this.account=account;
        this.code=code;
        this.date=date;
    }
    
    public VerifyUserAccount(){}
    
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id=id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public void setDate(String date){
        this.date=date;
    }
}
