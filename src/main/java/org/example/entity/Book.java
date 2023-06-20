package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
//    id, title, author, category, publishDate, availableDay, visible, createdDate
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "title" , nullable = false)
    private String title;
    @Column(name = "author" , nullable = false)
    private String author;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category  category;
    @Column(name = "published_date" , nullable = false)
    private LocalDate publishedDate;
    @Column(name = "available_day" , nullable = false)
    private Integer availableDay;
    @Column(name = "visible" , nullable = false)
    private Boolean visible;
    @Column(name = "created_date" , nullable = false)
    private LocalDate createdDate;


}
