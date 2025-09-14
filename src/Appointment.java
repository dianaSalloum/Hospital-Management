import java.time.LocalDateTime;
public class Appointment {
    private final int appointementId;
    private LocalDateTime date;
    private Doctor doctor;
    private Patient patient;

    public Appointment(int appointementId, LocalDateTime date, Doctor doctor, Patient patient) {
        this.appointementId = appointementId;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getAppointementId() {
        return appointementId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointementId=" + appointementId +
                ", date=" + date +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
