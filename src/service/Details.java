package service;

public class Details {

	
	public String EDT_EV_ID;
	public String EDT_EV_ISIN;
	public String EDT_ENTITY_ID;
	public String EDT_RECORD_DT;
	
	
	public Details() {
		super();
	}
	
	public String getEDT_EV_ID() {
		return EDT_EV_ID;
	}
	public void setEDT_EV_ID(String eDT_EV_ID) {
		EDT_EV_ID = eDT_EV_ID;
	}
	public String getEDT_EV_ISIN() {
		return EDT_EV_ISIN;
	}
	public void setEDT_EV_ISIN(String eDT_EV_ISIN) {
		EDT_EV_ISIN = eDT_EV_ISIN;
	}
	public String getEDT_ENTITY_ID() {
		return EDT_ENTITY_ID;
	}
	public void setEDT_ENTITY_ID(String eDT_ENTITY_ID) {
		EDT_ENTITY_ID = eDT_ENTITY_ID;
	}
	public String getEDT_RECORD_DT() {
		return EDT_RECORD_DT;
	}
	public void setEDT_RECORD_DT(String eDT_RECORD_DT) {
		EDT_RECORD_DT = eDT_RECORD_DT;
	}

	@Override
	public String toString() {
		return "Details [EDT_EV_ID=" + EDT_EV_ID + ", EDT_EV_ISIN=" + EDT_EV_ISIN + ", EDT_ENTITY_ID=" + EDT_ENTITY_ID
				+ ", EDT_RECORD_DT=" + EDT_RECORD_DT + "]";
	}

}
	
