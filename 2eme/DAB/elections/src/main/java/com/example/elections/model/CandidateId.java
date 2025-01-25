package com.example.elections.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CandidateId implements java.io.Serializable {
    private static final long serialVersionUID = 1185738335209945293L;
    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "election_id", nullable = false)
    private Integer electionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CandidateId entity = (CandidateId) o;
        return Objects.equals(this.electionId, entity.electionId) &&
                Objects.equals(this.personId, entity.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electionId, personId);
    }

}