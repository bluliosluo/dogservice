package org.chloe.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;


// 链接schema和java
@Entity
@Table(name = "dog_document")
public class DogDocumentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dogId;

    @Column(name = "name")
    private String dogName;

    @Column(name= "dog_breed")
    private String dogBreed;
    @Column(name = "created_at")    // 创建时间
    private Timestamp createdAt;
    @Column(name = "updated_at")    // 更新时间
    private Timestamp updatedAt;

    public DogDocumentModel() {
    }

    private DogDocumentModel(Builder builder) {
        setDogId(builder.dogId);
        setDogName(builder.dogName);
        setDogBreed(builder.dogBreed);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {

        private int dogId;
        private String dogName;
        private String dogBreed;
        private Timestamp createdAt;
        private Timestamp updatedAt;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withDogId(int val) {
            dogId = val;
            return this;
        }

        public Builder withDogName(String val) {
            dogName = val;
            return this;
        }

        public Builder withDogBreed(String val) {
            dogBreed = val;
            return this;
        }

        public Builder withCreatedAt(Timestamp val) {
            createdAt = val;
            return this;
        }

        public Builder withUpdatedAt(Timestamp val) {
            updatedAt = val;
            return this;
        }

        public DogDocumentModel build() {
            return new DogDocumentModel(this);
        }
    }
}
