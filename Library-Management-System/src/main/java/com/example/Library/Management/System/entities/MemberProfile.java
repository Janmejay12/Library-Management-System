package com.example.Library.Management.System.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MemberProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberProfileId;
    private String address;
    private String phoneNumber;


    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
