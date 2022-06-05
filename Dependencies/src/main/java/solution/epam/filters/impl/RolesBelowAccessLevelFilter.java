package solution.epam.filters.impl;

import solution.epam.Role;
import solution.epam.filters.RoleFilterWithAccessLevel;

/**
 * @author Ehtiram Etibarovich Abdullayev on 26.08.2019
 * @project oo-principles
 */
public class RolesBelowAccessLevelFilter implements RoleFilterWithAccessLevel {

    @Override
    public boolean elevate(Role currentRole, int accessLevel) {
        return currentRole.getAccessLevel() < accessLevel && currentRole.isEnabled();
    }
}
