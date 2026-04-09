package hu.nye.prog3.game_finder.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String releaseDate;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}