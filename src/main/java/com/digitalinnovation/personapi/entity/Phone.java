package com.digitalinnovation.personapi.entity;

import com.digitalinnovation.personapi.enums.PhoneType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
// @ToString, @EqualsAndHashCode, @Getter em todos os campos e @Sette rem todos os campos não-finais, e @RequiredArgsConstructor!
@Builder // Construtor de Objetos
@AllArgsConstructor
//@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;


    //Sugestão da IDEA abaixo  para reduzir consumo de recursos , removida @Data
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Phone phone = (Phone) o;

        return Objects.equals(id, phone.id);
    }

    @Override
    public int hashCode() {
        return 745010098;
    }
}
