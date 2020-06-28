package main.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Класс описывающий пользователя
 * @param "id" первичный ключ
 * @param "name" имя пользователя
 * @param "email" электронная почта пользователя
 */
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Proxy(lazy = false)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @NonNull
    @Column(name = "NAME")
    private String name;
    @NonNull
    @Column(name = "EMAIL")
    private String email;
}
