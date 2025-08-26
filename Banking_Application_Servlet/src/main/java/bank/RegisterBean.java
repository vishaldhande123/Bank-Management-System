package bank;

import java.io.Serializable;

public class RegisterBean implements Serializable
{
 private String uName,pWord,add,repass;
 private long amt,phNo,accNo,taccNo;
public RegisterBean() {
	super();
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public String getPass() {
	return pWord;
}
public void setPass(String pass) {
	this.pWord = pass;
}
public String getAdd() {
	return add;
}
public void setAdd(String add) {
	this.add = add;
}
public String getRepass() {
	return repass;
}
public void setRepass(String repass) {
	this.repass = repass;
}
public long getAmt() {
	return amt;
}
public void setAmt(long amt) {
	this.amt = amt;
}
public long getPhNo() {
	return phNo;
}
public void setPhNo(long phNo) {
	this.phNo = phNo;
}
public long getAccNo() {
	return accNo;
}
public void setAccNo(long accNo) {
	this.accNo = accNo;
}
public void settaccNo(long taccNo){
	this.taccNo = taccNo;
}
public long gettaccNo() {
	return taccNo;
}
@Override
public String toString() {
	return "RegisterBean [uName=" + uName + ", pass=" + pWord + ", add=" + add + ", repass=" + repass + ", amt=" + amt
			+ ", phNo=" + phNo + ", accNo=" + accNo + ", taccNo=" + taccNo + "]";
}

 
 
}