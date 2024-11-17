package dev.bandana.productservices.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private int id;
    private Date created;
    private Date Lastmodified;
    private boolean isdeleted;

}
