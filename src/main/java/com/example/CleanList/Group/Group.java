package com.example.CleanList.Group;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "`group`")
@Entity(name = "GroupEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_group")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_group;
    @Column(name = "name")
    private String name;
    @Column(name = "`order`")
    private int order;
}
