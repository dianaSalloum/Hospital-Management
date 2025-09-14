public class Patient extends Person{
    private String medicalHistory;
    private String bloodType;
    private String address;

    public Patient (int id,String name,int age,String gender,String phoneNumber,String medicalHistory,String bloodType,String address){
        super(id, name, age, gender, phoneNumber);
        this.medicalHistory=medicalHistory;
        this.address=address;
        this.bloodType=bloodType;
    }
    @Override
    public String toString() {
        return super.toString()+
                "is a Patient whose{" +
                "medical History='" + medicalHistory + '\'' +
                ", blood Type='" + bloodType + '\'' +
                ", address='" + address + '\'' +
                '}'+"\n";
    }
}
