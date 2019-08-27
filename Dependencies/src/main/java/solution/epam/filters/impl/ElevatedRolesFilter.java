package solution.epam.filters.impl;

import solution.epam.Role;
import solution.epam.filters.RoleFilter;

/**
 * @author Ehtiram Etibarovich Abdullayev on 26.08.2019
 * @project oo-principles
 */
public class ElevatedRolesFilter implements RoleFilter {
    @Override
    public boolean elevate(Role currentRole) {
        if (currentRole.isEnabled() && currentRole.isElevated()) {
            return true;
        }
        return false;
    }

}
