package solution.epam.filters;

import solution.epam.Role;

/**
 * @author Ehtiram Etibarovich Abdullayev on 26.08.2019
 * @project oo-principles
 */
public interface RoleFilterWithAccessLevel<T extends Role> {
    boolean elevate(T t, int accessLevel);
}
