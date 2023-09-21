package Hospital;

import java.io.IOException;

public class doctor extends patient {
    public doctor(int patientId, int pAge, String pName, String pPhone, String pSex) {
        super(patientId, pAge, pName, pPhone, pSex);
        //TODO Auto-generated constructor stub
    }
    String dname;
    String dsex;
    int dage,did;
   public void getDetails(String dname,String dsex,int dage,int did) throws IOException {

        this.dname= dname;
        this.dsex=dsex;
        this.dage= dage;
        this.did = did;
        super.getDetails();
        super();

    }

}
