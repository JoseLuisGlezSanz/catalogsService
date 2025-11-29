package com.example.catalogservice.mapper;

import com.example.catalogservice.dto.MembershipRequest;
import com.example.catalogservice.dto.MembershipResponse;
import com.example.catalogservice.model.Membership;

public class MembershipMapper {
    public static MembershipResponse toResponse(Membership membership) {
        if (membership == null) return null;

        return MembershipResponse.builder()
                .id(membership.getId())
                .name(membership.getName())
                .duration(membership.getDuration())
                .price(membership.getPrice())
                .status(membership.getStatus())
                .gymId(membership.getGymId())
                .build();
    }

    public static Membership toEntity(MembershipRequest membershipRequest) {
        if (membershipRequest == null) return null;
        
        return Membership.builder()
                .name(membershipRequest.getName())
                .duration(membershipRequest.getDuration())
                .price(membershipRequest.getPrice())
                .status(membershipRequest.getStatus())
                .gymId(membershipRequest.getGymId())
                .build();
    }

    public static void copyToEntity(MembershipRequest membershipRequest, Membership entity) {
        if (membershipRequest == null || entity == null) return;
        
        entity.setName(membershipRequest.getName());
        entity.setDuration(membershipRequest.getDuration());
        entity.setPrice(membershipRequest.getPrice());
        entity.setStatus(membershipRequest.getStatus());
        entity.setGymId(membershipRequest.getGymId());
    }
}