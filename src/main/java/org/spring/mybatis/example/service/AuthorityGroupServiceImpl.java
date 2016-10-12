package org.spring.mybatis.example.service;

import org.spring.mybatis.example.domain.security.AuthorityGroup;
import org.spring.mybatis.example.repository.AuthorityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AuthorityGroupServiceImpl implements AuthorityGroupService {

    private final AuthorityGroupRepository authorityGroupRepository;

    @Autowired
    public AuthorityGroupServiceImpl(final AuthorityGroupRepository authorityGroupRepository) {
        this.authorityGroupRepository = authorityGroupRepository;
    }

    @Override
    public AuthorityGroup findById(final Long id) throws Exception {
        return authorityGroupRepository.findById(id);
    }

    @Override
    public void insert(final AuthorityGroup authorityGroup) throws Exception {
        authorityGroupRepository.insert(authorityGroup);
    }

    @Override
    public void update(final AuthorityGroup authorityGroup) throws Exception {
        authorityGroupRepository.update(authorityGroup);
    }

    @Override
    public void delete(final Long id) throws Exception {
        authorityGroupRepository.delete(id);
    }

}
