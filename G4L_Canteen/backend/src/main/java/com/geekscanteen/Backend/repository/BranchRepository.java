package com.geekscanteen.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geekscanteen.Backend.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
