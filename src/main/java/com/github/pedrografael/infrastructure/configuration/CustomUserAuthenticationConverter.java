package com.github.pedrografael.infrastructure.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {

  public static final String REALM_ACCESS = "realm_access";

  public static final String ROLES = "roles";

  public static final String PREFERRED_USERNAME = "preferred_username";

  @Override
  public Map<String, ?> convertUserAuthentication(Authentication authentication) {
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put(USERNAME, authentication.getName());
    if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
      response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
    }
    return response;
  }

  public Authentication extractAuthentication(Map<String, ?> map) {
    if (map.containsKey(PREFERRED_USERNAME)) {
      Object principal = map.get(PREFERRED_USERNAME);
      Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
      return new UsernamePasswordAuthenticationToken(principal, "N/A", authorities);
    }
    return null;
  }

  private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
    if (!map.containsKey(REALM_ACCESS)) {
      return new ArrayList<>();
    }
    @SuppressWarnings("unchecked")
    Map<String, ?> realmAccess = (Map<String, ?>) map.get(REALM_ACCESS);
    Object authorities = realmAccess.get(ROLES);
    if (authorities instanceof String) {
      return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
    }
    if (authorities instanceof Collection) {
      return AuthorityUtils.commaSeparatedStringToAuthorityList(
          StringUtils.collectionToCommaDelimitedString((Collection<?>) authorities));
    }
    throw new IllegalArgumentException("Authorities must be either a String or a Collection");
  }

}
