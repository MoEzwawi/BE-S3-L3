package MoEzwawi.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @Column(name = "event_code")
    @GeneratedValue
    private long id;
    @Column(name = "event_title")
    private String title;
    @Column(name = "event_date")
    private LocalDate eventDate;
    @Column(name = "event_description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;
    @Column(name = "venue_capacity")
    private int maximumCapacity;
    public Event(){

    }
    public Event(String title, LocalDate eventDate, EventType eventType) {
        this.title = title;
        this.eventDate = eventDate;
        this.eventType = eventType;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }
    public static LocalDate parseDateForItaly (String date){
        LocalDate parsedDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALY);
            parsedDate = LocalDate.parse(date, formatter);
        } catch(DateTimeParseException e){
            System.err.println("Il formato data inserito non è valido!");
        }
        return parsedDate;
    }
    public static LocalDate parseDateForUSA (String date){
        LocalDate parsedDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ITALY);
            parsedDate = LocalDate.parse(date, formatter);
        } catch(DateTimeParseException e){
            System.err.println("Il formato data inserito non è valido!");
        }
        return parsedDate;
    }
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maximumCapacity=" + maximumCapacity +
                '}';
    }
}
