package shr;

import org.openqa.selenium.WebDriver;

public class Evencreation {

	String ISIN ;
	String ISIN_Description ;
	String Issuer ;
	String Voting_Start_Date ;
	String Voting_End_Date ;
	String Voting_Result_Date ;
	String Cut_Off_Date;
	String General_Meeting_Date;
	String Last_date_dispatch;
	String Evoting_Start_Time;
	String Evoting_End_Time;
	String General_Meeting_Start_Time;
	WebDriver driver;

	public Evencreation() {
	super();	
	}


	public String getCut_Off_Date() {
		return Cut_Off_Date;
	}

	public void setCut_Off_Date(String cut_Off_Date) {
		Cut_Off_Date = cut_Off_Date;
	}

	public String getGeneral_Meeting_Date() {
		return General_Meeting_Date;
	}

	public void setGeneral_Meeting_Date(String general_Meeting_Date) {
		General_Meeting_Date = general_Meeting_Date;
	}

	public String getLast_date_dispatch() {
		return Last_date_dispatch;
	}

	public void setLast_date_dispatch(String last_date_dispatch) {
		Last_date_dispatch = last_date_dispatch;
	}

	public String getEvoting_Start_Time() {
		return Evoting_Start_Time;
	}

	public void setEvoting_Start_Time(String evoting_Start_Time) {
		Evoting_Start_Time = evoting_Start_Time;
	}

	public String getEvoting_End_Time() {
		return Evoting_End_Time;
	}

	public void setEvoting_End_Time(String evoting_End_Time) {
		Evoting_End_Time = evoting_End_Time;
	}

	public String getGeneral_Meeting_Start_Time() {
		return General_Meeting_Start_Time;
	}

	public void setGeneral_Meeting_Start_Time(String general_Meeting_Start_Time) {
		General_Meeting_Start_Time = general_Meeting_Start_Time;
	}

	public String getISIN() {
		return ISIN;
	}
	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}
	public String getISIN_Description() {
		return ISIN_Description;
	}
	public void setISIN_Description(String iSIN_Description) {
		ISIN_Description = iSIN_Description;
	}
	public String getIssuer() {
		return Issuer;
	}
	public void setIssuer(String issuer) {
		Issuer = issuer;
	}
	public String getVoting_Start_Date() {
		return Voting_Start_Date;
	}
	public void setVoting_Start_Date(String voting_Start_Date) {
		Voting_Start_Date = voting_Start_Date;
	}
	public String getVoting_End_Date() {
		return Voting_End_Date;
	}
	public void setVoting_End_Date(String voting_End_Date) {
		Voting_End_Date = voting_End_Date;
	}
	public String getVoting_Result_Date() {
		return Voting_Result_Date;
	}
	public void setVoting_Result_Date(String voting_Result_Date) {
		Voting_Result_Date = voting_Result_Date;
	}


	@Override
	public String toString() {
		return "Evencreation [ISIN=" + ISIN + ", ISIN_Description=" + ISIN_Description + ", Issuer=" + Issuer
				+ ", Voting_Start_Date=" + Voting_Start_Date + ", Voting_End_Date=" + Voting_End_Date
				+ ", Voting_Result_Date=" + Voting_Result_Date + ", Cut_Off_Date=" + Cut_Off_Date
				+ ", General_Meeting_Date=" + General_Meeting_Date + ", Last_date_dispatch=" + Last_date_dispatch
				+ ", Evoting_Start_Time=" + Evoting_Start_Time + ", Evoting_End_Time=" + Evoting_End_Time
				+ ", General_Meeting_Start_Time=" + General_Meeting_Start_Time + "]";
	}



}
