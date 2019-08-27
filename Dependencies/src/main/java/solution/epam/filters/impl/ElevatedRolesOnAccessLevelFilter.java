package solution.epam.filters.impl;

import solution.epam.Role;
import solution.epam.filters.RoleFilterWithAccessLevel;

/**
 * @author Ehtiram Etibarovich Abdullayev on 26.08.2019
 * @project oo-principles
 */
public class ElevatedRolesOnAccessLevelFilter implements RoleFilterWithAccessLevel {
    @Override
    public boolean elevate(Role currentRole, int accessLevel) {
        if (currentRole.getAccessLevel() == accessLevel && currentRole.isEnabled() && currentRole.isElevated()) {
            return true;
        }
        return false;
    }
}
