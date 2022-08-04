package com.human.pet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//엔티티 : JPA가 관리하는 엔티티로 인식하게 하는 어노테이션
//@Id : 엔티티로 생성된 객체는 반드시 다른 객체와 식별할 수 있도록 설정
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private long id;
    private String name;
}

//public class Member {
//
//}

