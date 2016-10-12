package org.spring.mybatis.example.service;

import org.spring.mybatis.example.domain.security.AuthorityGroup;

public interface AuthorityGroupService {

    AuthorityGroup findById(final Long id) throws Exception;

    void insert(final AuthorityGroup authorityGroup) throws Exception;

    void update(final AuthorityGroup authorityGroup) throws Exception;

    void delete(final Long id) throws Exception;

}
