package org.spring.mybatis.example.domain.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.apache.ibatis.type.Alias;

@Alias("AuthorityGroup")
@JsonDeserialize(builder = AuthorityGroup.Builder.class)
public class AuthorityGroup {

    private Long id;
    private String name;
    private String description;
    private String createdBy;

    public AuthorityGroup() { }

    private AuthorityGroup(final Builder builder) {
        id = builder.id;
        createdBy = builder.createdBy;
        name = builder.name;
        description = builder.description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public static Builder anAuthorityGroup() {
        return new Builder();
    }

    public static Builder anAuthorityGroup(final AuthorityGroup authorityGroup) {
        return new Builder(authorityGroup);
    }

    @JsonPOJOBuilder
    public static final class Builder {

        private Long id;
        private String createdBy;
        private String name;
        private String description;

        private Builder(final AuthorityGroup authorityGroup) {
            this.id = authorityGroup.id;
            this.createdBy = authorityGroup.createdBy;
            this.name = authorityGroup.name;
            this.description = authorityGroup.description;
        }

        private Builder() {
        }

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withCreatedBy(final String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public AuthorityGroup build() {
            return new AuthorityGroup(this);
        }

    }

}
