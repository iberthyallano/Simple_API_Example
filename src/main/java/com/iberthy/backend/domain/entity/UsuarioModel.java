package com.iberthy.backend.domain.entity;

import com.iberthy.backend.domain.abstracts.PessoaModel;
import com.iberthy.backend.util.Message;
import com.iberthy.backend.domain.validation.rolesUsuario.RolesUsuarioValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UsuarioModel extends PessoaModel implements UserDetails {

    @NotBlank(message = Message.userNameNotBlank)
    private String username;

    @NotBlank(message = Message.passwordNotBlank)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @RolesUsuarioValidate
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (String role : this.roles) {authorities.add(new SimpleGrantedAuthority(role));}

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}
