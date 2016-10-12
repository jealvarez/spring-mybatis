package org.spring.mybatis.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mybatis.example.configuration.MySqlDataSourceConfiguration;
import org.spring.mybatis.example.configuration.PropertyPlaceholderConfiguration;
import org.spring.mybatis.example.domain.security.AuthorityGroup;
import org.spring.mybatis.example.repository.AuthorityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PropertyPlaceholderConfiguration.class, MySqlDataSourceConfiguration.class})
public class AuthorityGroupRepositoryIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private AuthorityGroupRepository authorityGroupRepository;

    @Test
    public void testFindById() throws Exception {
        final AuthorityGroup expectedAuthorityGroup = anAuthorityGroup();
        authorityGroupRepository.insert(expectedAuthorityGroup);

        final AuthorityGroup actualAuthorityGroup = authorityGroupRepository.findById(expectedAuthorityGroup.getId());

        assertThat(actualAuthorityGroup, is(not(nullValue())));
        assertThat(actualAuthorityGroup.getId(), is(not(nullValue())));
        assertThat(actualAuthorityGroup.getCreatedBy(), is(expectedAuthorityGroup.getCreatedBy()));
        assertThat(actualAuthorityGroup.getName(), is(expectedAuthorityGroup.getName()));
        assertThat(actualAuthorityGroup.getDescription(), is(expectedAuthorityGroup.getDescription()));
    }

    @Test
    public void testInsert() throws Exception {
        final AuthorityGroup authorityGroup = anAuthorityGroup();
        authorityGroupRepository.insert(authorityGroup);

        assertThat(authorityGroup.getId(), is(not(nullValue())));
    }

    @Test
    public void testDelete() throws Exception {
        final AuthorityGroup authorityGroup = anAuthorityGroup();
        authorityGroupRepository.insert(authorityGroup);

        final int rowsAffected = authorityGroupRepository.delete(authorityGroup.getId());

        assertThat(rowsAffected, is(1));
    }

    @Test
    public void testUpdate() throws Exception {
        final AuthorityGroup authorityGroup = anAuthorityGroup();
        authorityGroupRepository.insert(authorityGroup);

        final AuthorityGroup expectedAuthorityGroup = AuthorityGroup.anAuthorityGroup(authorityGroup)
                .withCreatedBy("SYSTEM_TEST_2")
                .withName("ROLE_TEST_2")
                .withDescription("DESCRIPTION_TEST_2")
                .build();

        final int rowsAffected = authorityGroupRepository.update(expectedAuthorityGroup);

        assertThat(rowsAffected, is(1));
    }

    private AuthorityGroup anAuthorityGroup() {
        return AuthorityGroup.anAuthorityGroup()
                .withCreatedBy("SYSTEM_TEST")
                .withName("ROLE_TEST")
                .withDescription("DESCRIPTION_TEST")
                .build();
    }

}
