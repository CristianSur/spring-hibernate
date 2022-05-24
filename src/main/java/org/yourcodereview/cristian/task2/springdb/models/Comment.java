package org.yourcodereview.cristian.task2.springdb.models;




import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Comment can't be empty")
    @Size(min = 2, max = 30, message = "Comment should contain from 2 to 30 characters")
    @Column(name = "text")
    private String text;

}
