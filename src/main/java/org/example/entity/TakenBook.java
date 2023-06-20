package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.BookStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "taken_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TakenBook {

//    id, studentId, bookId, createdDate, Status(TOOK,RETURNED),note
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Profile studentId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private Book bookId;
    @Column(name = "created_date" , nullable = false)
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false)
    private BookStatus status;
    @Column(name = "note" , nullable = false,columnDefinition = "TEXT")
    private String note;

}
