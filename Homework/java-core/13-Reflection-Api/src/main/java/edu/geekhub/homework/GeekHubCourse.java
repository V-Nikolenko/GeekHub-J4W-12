package edu.geekhub.homework;

import edu.geekhub.homework.inject.Injectable;

public class GeekHubCourse {
    @Injectable(propertyName = "courseName")
    private String name;
    @Injectable(propertyName = "duration")
    private int duration;
    @Injectable
    private String description;
    @Injectable(propertyName = "mentor")
    private String mentorName;
    @Injectable
    private int registrations;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private String getMentorName() {
        return mentorName;
    }

    private void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    private int getRegistrations() {
        return registrations;
    }

    private void setRegistrations(int registrations) {
        this.registrations = registrations;
    }
}
