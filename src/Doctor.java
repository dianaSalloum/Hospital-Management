public class Doctor extends Person{
    private String specialization;
    private double salary;
    private int yearsOfExperience;
    private double consultationFee;
    public Doctor(int id, String name, int age, String gender, String phoneNumber, String specialization, double salary, int yearsOfExperience,double consultationFee) {
        super(id, name, age, gender, phoneNumber);
        this.specialization = specialization;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.consultationFee=consultationFee;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    @Override
    public String toString() {
        return super.toString()+
                "is a Doctor whose{" +
                "specialization='" + specialization + '\'' +
                ", salary=" + salary +
                ", years Of Experience=" + yearsOfExperience +
                '}'+"\n";
    }
}
