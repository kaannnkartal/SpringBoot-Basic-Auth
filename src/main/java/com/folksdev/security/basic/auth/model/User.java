package com.folksdev.security.basic.auth.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class User implements UserDetails {
    // UserDetails implement ediyoruz,yani bizim user sınıfımızı bir referans olarak tanıtıyoruz Cünkü;
    // Security Context desin ki Bu Security Containerında olacak bir class, ben bunu burada tutayım.
    // Bunu yapmamızı da UserDetails org.springframework.security.core.userdetails.UserDetails; sağlıyor.


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    private boolean accountNonExpired; // Get methodunu userDetails yakalayabilsin ??
    private boolean isEnabled; // zorunlu alanlar..
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    // Bir user'ın birden fazla rolü olsun istiyorsak Set yapıyoruz,
    // Eğer bir user'ın tek bir rolü olsun istiyorsak Düz Role olarak one to one iliski kurabiliriz
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    // Uygulama tarafına bir enum'a karşılık geldiğini soylemnis oluyoruz.

    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;







}
