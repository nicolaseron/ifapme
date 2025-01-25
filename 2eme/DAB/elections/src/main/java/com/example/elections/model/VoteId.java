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
public class VoteId implements java.io.Serializable {
    private static final long serialVersionUID = 7381650542008314165L;
    @Column(name = "voter_id", nullable = false)
    private Integer voterId;

    @Column(name = "election_id", nullable = false)
    private Integer electionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VoteId entity = (VoteId) o;
        return Objects.equals(this.electionId, entity.electionId) &&
                Objects.equals(this.voterId, entity.voterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electionId, voterId);
    }

}