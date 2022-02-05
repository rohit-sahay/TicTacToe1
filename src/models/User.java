package models;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private String email;
    private String phone;
    private String photo;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private User user;

        Builder() {
            user = new User();
        }

        public Builder name(String name) {
            user.name = name;
            return this;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder phone(String phone) {
            user.phone = phone;
            return this;
        }

        public Builder photo(String photo) {
            user.photo = photo;
            return this;
        }

        public boolean isValid() {
            return user.name != null;
        }

        public User build() {
            if (isValid()) {
                return user;
            }
            throw new IllegalStateException("User is not valid...Please provide name");
        }
    }
}
