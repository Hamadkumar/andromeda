package com.io.andromeda.service.currentuser;

import com.io.andromeda.domain.CurrentUser;

/**
 * @author hamad
 *
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
