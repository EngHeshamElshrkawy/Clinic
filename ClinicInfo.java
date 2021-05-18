public class ClinicInfo {
    String nameOfClinic;
    String nameOfDoctor;
    String address;
    String phoneNumber;

    public ClinicInfo(){
        this.nameOfClinic = "";
        this.nameOfDoctor = "";
        this.address = "" ;
        this.phoneNumber = "";
    }

    public ClinicInfo(String nameOfClinic, String nameOfDoctor, String address, String phoneNumber){
        this.nameOfClinic = nameOfClinic;
        this.nameOfDoctor = nameOfDoctor;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setClinicName(String nameOfClinic){
        this.nameOfClinic = nameOfClinic;
    }

    public void setDoctorName(String nameOfDoctor){
        this.nameOfDoctor = nameOfDoctor;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getClinicName(){
        return this.nameOfClinic;
    }

    public String getDoctorName(){
        return this.nameOfDoctor;
    }

    public String getAddress(){
        return this.address;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
}
