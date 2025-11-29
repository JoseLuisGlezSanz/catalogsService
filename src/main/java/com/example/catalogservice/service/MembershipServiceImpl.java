package com.example.catalogservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.catalogservice.dto.MembershipRequest;
import com.example.catalogservice.dto.MembershipResponse;
import com.example.catalogservice.mapper.MembershipMapper;
import com.example.catalogservice.model.Membership;
import com.example.catalogservice.repository.MembershipRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MembershipServiceImpl implements MembershipService{
    private final MembershipRepository membershipRepository;
    // private final GymClient gymClient;

    @Override
    public List<MembershipResponse> findAll() {
        return membershipRepository.findAll().stream()
                .map(MembershipMapper::toResponse)
                .toList();
    }

    @Override
    public MembershipResponse findById(Long id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada con ID: " + id));

        return MembershipMapper.toResponse(membership);
    }

    @Override
    public MembershipResponse create(MembershipRequest membershipRequest) {
        // VALIDAR que el gym existe usando Feign Client
        // Gym gym = gymClient.existsById(membershipRequest.getGymId());
        // if (gym == null) {
        //     throw new RuntimeException("Gimnasio no encontrado con ID: " + membershipRequest.getGymId());
        // }
        
        Membership membership = MembershipMapper.toEntity(membershipRequest);
       
        Membership savedMembership = membershipRepository.save(membership);
        return MembershipMapper.toResponse(savedMembership);
    }

    @Override
    public MembershipResponse update(Long id, MembershipRequest membershipRequest) {
        Membership existingMembership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada con ID: " + id));

        // VALIDAR que el gym existe usando Feign Client
        // Gym gym = gymClient.existsById(membershipRequest.getGymId());
        // if (gym == null) {
        //     throw new RuntimeException("Gimnasio no encontrado con ID: " + membershipRequest.getGymId());
        // }
        
        MembershipMapper.copyToEntity(membershipRequest, existingMembership);

        Membership updatedMembership = membershipRepository.save(existingMembership);
        return MembershipMapper.toResponse(updatedMembership);
    }

    // @Override
    // public void delete(Long id) {
    //     membershipRepository.deleteById(id);
    // }

    @Override
    public List<MembershipResponse> findMembershipByName(String membership) {
        List<Membership> memberships = membershipRepository.findMembershipByName(membership);
        return memberships.stream().map(MembershipMapper::toResponse).toList();
    }

    @Override
    public List<MembershipResponse> findMembershipByGymId(Long gymId) {
        List<Membership> memberships = membershipRepository.findMembershipByGymId(gymId);
        return memberships.stream().map(MembershipMapper::toResponse).toList();
    }
}